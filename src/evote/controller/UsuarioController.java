package evote.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import evote.dao.EntityDAO;
import evote.dao.Query;
import evote.model.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3663458920209520602L;
	private List<Usuario> users;
	
	public List<Usuario> getUsers() {
		return users;
	}

	public void setUsers(List<Usuario> users) {
		this.users = users;
	}

	public UsuarioController()
	{
		users =  EntityDAO.findAll(Query.QUERY_USERS_ALL);
	}
	
	public void addNew()
	{
		users.add(new Usuario());
	}
	
	public void save()
	{
		for(Usuario u: users)
		{
		EntityDAO.saveOrUpdate(u);
		}
	}

}
