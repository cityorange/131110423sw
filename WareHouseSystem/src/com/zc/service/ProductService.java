package com.zc.service;

import java.util.List;

import javax.swing.JTable;

import com.zc.DAO.ProductDAO;
import com.zc.control.ProductControl;
import com.zc.model.Product;

public class ProductService{
	public static Product temp=null;

	
	public static void readProduct(JTable table)
	{
		
		List<?> product1=ProductControl.getControl().getProductAll();
		for(int i=0;i<product1.size();i++)
		{
			temp=new Product();	
			temp=(Product)product1.get(i);
			table.setValueAt(temp.getPid(), i, 0);
			table.setValueAt(temp.getProductName(),i,1);
			table.setValueAt(temp.getPrice(),i , 2);
			table.setValueAt(temp.getNum(),i,3);
			table.setValueAt(temp.getTotalPrice(),i,4);}
			
			
			
		
		
		}
	
	public static void readFindQuery(JTable table,Product temp)
	{
		table.setValueAt(temp.getPid(), 0, 0);
		table.setValueAt(temp.getProductName(),0,1);
		table.setValueAt(temp.getPrice(),0,2);
		table.setValueAt(temp.getNum(),0,3);
		table.setValueAt(temp.getTotalPrice(),0,4);
		}
		
		
	
		
		public static boolean deleteProduct(int i)
		{
			
			List<?> product2=ProductControl.getControl().getProductAll();
			temp=new Product();
			temp=(Product)product2.get(i);
			
			
			
			
			boolean flag=ProductControl.getControl().delete(temp);
			
			return flag;
			
		}
			
			
			
			
		public static Product update(int i)
		{   
			
			List<?> product=ProductControl.getControl().getProductAll();
			temp=new Product();
			temp=(Product)product.get(i);
            
		    	
			return temp;
            
			
			
		}
		
			
			
		
		
	
	
	
	
}