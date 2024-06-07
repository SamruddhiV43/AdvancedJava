package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestJDBCConnection {

	public static void main(String[] args) {
//step 1:Register Driver
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			//168.10.150-->IPAddress
			//3306---->Port number
			//dac76---->database  
			
			String url="jdbc:mysql://192.168.10.150:3306/dac76";
//Step 2: GetConnection
			Connection conn=DriverManager.getConnection(url,"dac76","welcome");
			//check whether connection is done or not
			if(conn!=null)
			{
				System.out.println("Connection done");
			}
			
//Step 3:Create statement
			Statement st= conn.createStatement();
//Select data
			
			int id=7;
			String fname="sam";
			String lname="virkhare";
			String q="insert into person values("+id+",'"+fname+"','"+lname+"')";
			System.out.println("Query :"+q);
			//execute update for inserting data into table
			int n=st.executeUpdate(q);
			if(n>0) {
				System.out.println("inserted");
			}
			
			
			ResultSet rs=st.executeQuery("Select * from person");
			while(rs.next())
			{
				System.out.println("id :"+rs.getInt(1));
				//if we know exact colname we can put colname instead of col number
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("fname :"+rs.getString(2));
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("lname :"+rs.getString(3));
				//System.out.println("fname :"+rs.getString("fname"));
				
			}
//update data 
			//getting input from user to update
		Scanner sc=new Scanner(System.in);
			System.out.println("Enter person id to update ");
		int pid=sc.nextInt();
			System.out.println("Enter person first name to update ");
		String fnm=sc.next();
			System.out.println("ENTER person LAst Nmae to update");
			String lnm=sc.next();
		String q1="update person set fname='"+fnm+"',lname='"+lnm+"' where id="+pid+"";
			System.out.println("Query :"+q1);
			n=st.executeUpdate(q1);
			if(n>0) {
				System.out.println("updated");
			}
			 rs=st.executeQuery("Select * from person");
			while(rs.next())
			{
				System.out.println("id :"+rs.getInt(1));
				//if we know exact colname we can put colname instead of col number
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("fname :"+rs.getString(2));
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("lname :"+rs.getString(3));
				//System.out.println("fname :"+rs.getString("fname"));
				
			}
//delete data 
			String q2="delete from person where fname='sam'";
			System.out.println("Query :"+q2);
			n=st.executeUpdate(q2);
			if(n>0) {
				System.out.println("deleted");
			}
			 rs=st.executeQuery("Select * from person");
			while(rs.next())
			{
				System.out.println("id :"+rs.getInt(1));
				//if we know exact colname we can put colname instead of col number
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("fname :"+rs.getString(2));
				//System.out.println("fname :"+rs.getString("fname"));
				System.out.println("lname :"+rs.getString(3));
				//System.out.println("fname :"+rs.getString("fname"));
				
			}
			
		conn.close();
			 //if connection is closed then no STATEMENT is update delete or insert
			
			
			//check whether connection is closed or not
			if (conn.isClosed()) {
			    System.out.println("The connection is closed.");
			} else {
			    System.out.println("The connection is not closed.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
}
