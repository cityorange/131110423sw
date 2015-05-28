package com.zc.service;


	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Vector;

	
	import com.zc.util.DBUtil;

		public class ProductService {
			//²éÑ¯È«²¿
			public Vector<Vector<Object>> findAll() throws SQLException{
				Vector<Vector<Object>> ps = new Vector<Vector<Object>>();
				ResultSet rs=null;
				PreparedStatement pstmt=null;
				Connection conn=null;
				try {
					conn = DBUtil.getConn();
					String sql="select * from product";
					pstmt=conn.prepareStatement(sql);
					rs= pstmt.executeQuery();
					while(rs.next()){
						Vector<Object> products = new Vector<Object>();
						products.add(rs.getString("pid"));
						products.add(rs.getString("product-name"));
						products.add(rs.getDouble("price"));
						products.add(rs.getInt("num"));
						products.add(rs.getDouble("total-price"));
						ps.add(products);
					}
				} catch (SQLException e) {
					throw new SQLException();	
				}finally{
					DBUtil.close(rs, pstmt, conn);
				}
				
				return ps;
			}
		 


}
