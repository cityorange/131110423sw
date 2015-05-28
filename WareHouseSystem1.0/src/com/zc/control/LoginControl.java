package com.zc.control;

import java.util.List;

import org.hibernate.Session;

import com.zc.DOA.HibernateSessionFactory;
import com.zc.DOA.UserDAO;
import com.zc.model.User;


public class LoginControl {

	private static LoginControl control=null;
	public static LoginControl getLoginControl(){
		if(null==control)
		{
			control=new LoginControl();
			
		}
		return control;
	}
	
	
	private UserDAO userDAO=null;
	private Session session=null;
	private LoginControl(){
		userDAO=new UserDAO();
		session = HibernateSessionFactory.getSession();
	}
		
	
	public User saveUser(String id,String password){
		User user=new User(id,"",password);
		userDAO.save(user);
		session.beginTransaction().commit();
		session.flush();
		return user;
	}
		
	
	public User getUserById(String id){
		return userDAO.findById(id);
	}
		
	
	public List getUserALL(){
		
		return userDAO.findAll();
		
	}
	
	
	public Boolean delete(User user) {
		try {

			userDAO.delete(user);
			session.beginTransaction().commit();
			session.flush();
			return true;

		} catch (Exception e) {
			return false;
		}
		
		
/*
		public boolean merge(User user) {
			try {

				userDAO.merge(user);
				session.beginTransaction().commit();
				session.flush();
				return true;

			} catch (Exception e) {
				return false;
			}
		}*/
		
	}
	
	
	
	
	}
	
	

