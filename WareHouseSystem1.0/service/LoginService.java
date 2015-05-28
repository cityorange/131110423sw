package com.zc.service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zc.util.DBUtil;



public class LoginService {
	public  boolean Login(String user,String password) throws Exception{
	Connection conn= null;
	PreparedStatement pstmt= null;
	ResultSet rs=null;
	try{
		conn=DBUtil.getConn();
		String sql="select * from user where id=? and password=?";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,user);
		pstmt.setString(2,password);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			return true;
		}
		
		else{
			return false;
		}
	}
	
	catch(SQLException e)
	{
		throw new SQLException();
		
	}
	finally{
		DBUtil.close(rs, pstmt, conn);
	}
	}
}
	

