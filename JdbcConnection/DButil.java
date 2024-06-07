package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {
	static Connection conn ;
	public static Connection getMyConnection()
	{   
		if(conn==null)//if connection is not done
		{
			try {//make connection
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				 String url="jdbc:mysql://192.168.10.150:3306/dac76";
				 Connection conn=DriverManager.getConnection(url,"dac76","welcome");	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	public static void closeConnection()
	{
		if(conn!=null)
				
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
