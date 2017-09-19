package com.chiansoft.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	public static Connection getConnection(String user,String password){
		Connection conn = null;
		try {
//			1.加载驱动
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			2.获取连接对象
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection
					(url,"SCOTT","TIGER");
//			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	} 
	
	public static void close(ResultSet rs,Statement stat,Connection conn){
		try {
//			6.关闭连接
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
