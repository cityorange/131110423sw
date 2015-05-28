package com.zc.service;



import java.util.List;

import javax.swing.JComboBox;

import com.zc.DOA.UserDAO;
import com.zc.control.LoginControl;
import com.zc.model.User;

public class LoginService {
	
	//负责判断用户是否存在
	public static Boolean isUser(String id,String password)
	{
		User user = LoginControl.getLoginControl().getUserById(id);
		if(password.equals(user.getPassword()))
			return true;
		else
			return false;
			
		
	}
	

	public static boolean checkUser(String id,String password)
	{
		 if(!"".equals(id.trim())&&!"".equals(password.trim()))
				 {
			  return true;
				 }
		 else{
			 return false;
	       }
	}

	//负责将数据库中的用户id读进来
	public static void readUser(JComboBox comboBox)
	{
		List logins = LoginControl.getLoginControl().getUserALL();
		for(int i = 0;i<logins.size();i++)
		{
			comboBox.addItem(((User)logins.get(i)).getId());
	    }
		
	}
	

}
