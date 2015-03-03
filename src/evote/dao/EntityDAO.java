package evote.dao;
	
	import java.io.Serializable;
	import java.util.List;

	import org.hibernate.Session;

	public class EntityDAO<Entity extends Serializable> {
		
		private static Session session; 
		private static boolean init()
		{
			try{
			session = HibernateUtil.getSessionFactory().openSession();
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
		}
		
		public static void persist(Serializable entity) {
			init();
			session.beginTransaction();
			session.persist(entity);
			session.getTransaction().commit();
		}
		
		public static void saveOrUpdate(Serializable entity)
		{
			init();
			session.beginTransaction();
			session.saveOrUpdate(entity);
			session.getTransaction().commit();
		}
		public void update(Serializable entity) {
			init();
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		}
		
		public static void delete(Serializable entity) {
			init();
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		}
		
		@SuppressWarnings("unchecked")
		public static <Entity extends Serializable> List<Entity> findAll(final Query query) {
			init();
			return (List<Entity>)session.createQuery(query.getValue()).list();
		}
		
		@SuppressWarnings("unchecked")
		public static <Entity extends Serializable> Entity findByID(Class<?> clazz, Serializable id) {
			init();
			return (Entity) session.get(clazz, id);
		}		
		@Override
		protected void finalize() throws Throwable {
			if (session.isOpen())
				session.close();
		}
		
		public void close() {
			if (session.isOpen())
				session.close();
		}
		
	}
	

