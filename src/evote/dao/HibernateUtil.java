package evote.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
	
		private static final SessionFactory sessionFactory = buildSessionFactory();
		 
		private static SessionFactory buildSessionFactory() {
			try {
				Configuration configuration = new Configuration().configure();
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				return configuration.buildSessionFactory(builder.build());
			} catch (Throwable ex) {
				throw new ExceptionInInitializerError(ex);
			}
		}
	 
		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
	 
		public static void shutdown() {
			getSessionFactory().close();
		}
		
		@Override
		protected void finalize() throws Throwable {
			try {
				shutdown();
			} catch(Exception e) { }
		}
	}


