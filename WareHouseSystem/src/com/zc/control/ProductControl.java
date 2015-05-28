package com.zc.control;

import java.util.List;

import org.hibernate.Session;

import com.zc.DOA.HibernateSessionFactory;
import com.zc.DOA.ProductDAO;
import com.zc.model.Product;

public class ProductControl {

	
	private static ProductControl control=null;
	public static ProductControl getControl(){
		if(control==null)
		{
			
			control=new ProductControl();
		}
		return control;
	}
	
	
	
	private ProductDAO productDAO=null;
	private Session session=null;
	
	
	
	public ProductControl(){
		
		productDAO=new ProductDAO();
		session= HibernateSessionFactory.getSession();
		
		
	} 
	
	
	public Boolean saveProduct(String pid, String productName, Double price, Integer num,
			Double totalPrice){
		
		try{
			Product product=new Product(pid, productName,  price,  num,
		
			 totalPrice);
		  productDAO.save(product);
		session.beginTransaction().commit();
		session.flush();
          return true;	
	}catch(Exception e){
		return false;
	}
	}
	
	public List getProductAll(){
		
		return productDAO.findAll();
		
	}
	
	

	public Product findById(String id) {
		try {
			return productDAO.findById(id);
			
		} catch (Exception e) {
			return null;
		}
		
		

	}
	
	public Boolean findByID(String id) {
		try {
			
			productDAO.findById(id);
			session.beginTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		
		
	}
	
	
	
	
	
	public boolean delete(Product product){
		try{
			productDAO.delete(product);
			session.beginTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			return false;
		}
		
	
	}
	
	
	
	
	public List findByPname(String pname)
	{
		try
			{
			
					return productDAO.findByProductName(pname);
					
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	
	public Boolean findByPName(String pname) {
		try {
			productDAO.findByProductName(pname);
			session.beginTransaction().commit();
			session.flush();
			return true;
		} catch (Exception e) {
			return false;
		}
		
		

	}
	
	public boolean update(Product product)
	{
		try{
			productDAO.merge(product);
			session.beginTransaction().commit();
			session.flush();
			return true;
			
			
			
		}catch(Exception e){
			
			return false;
		}
		
	}
	}
	
	
	
	/*public Boolean updateProduct(String pid, String productName, Double price, Integer num,
			Double totalPrice){
		
		try{
			Product product=new Product(pid, productName,  price,  num,
		
			 totalPrice);
		  productDAO.merge(product);
		session.beginTransaction().commit();
		session.flush();
          return true;	
	}catch(Exception e){
		return false;
	}
	}
	
	
	}
	*/

