package evote.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import evote.dao.EntityDAO;
import evote.dao.Query;
import evote.model.Test1;

@ManagedBean
@ViewScoped
public class TestController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Test1>lista;
	//private EntityDAO<Test1>entity;
	public List<Test1> getLista()
	{
		return lista;
	}
	public void setLista(List<Test1> lista)
	{
		this.lista = lista;
	}
	
	public TestController()
	{
		lista =  EntityDAO.findAll(Query.QUERY_TEST1_ALL);
	}
	
	public void addNew()
	{
		lista.add(new Test1());
	}
	
	public String save()
	{
		for(Test1 test:lista)
		{
			try{
			EntityDAO.saveOrUpdate(test);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
}
