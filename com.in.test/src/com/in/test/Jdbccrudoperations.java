package com.in.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Jdbccrudoperations {

	final String driver="com.mysql.jdbc.Driver";
	final String dburl="jdbc:mysql://localhost/sys";
	final String username="root";
	final String password="World!1";
	Connection con = null;
	PreparedStatement pre;
	Scanner sc=new Scanner(System.in);
	Boolean result=false;
	public void insert()
	{
		try {
			Class.forName(driver);
			System.out.println("Driver loaded");
			con=DriverManager.getConnection(dburl,username,password);
			System.out.println("Database selected..");
			String query="insert into employee (empno,empname,age) values(?,?,?)";
			pre=con.prepareStatement(query);
			System.out.println("Enter Your Employee no:");
			int no=sc.nextInt();
			pre.setInt(1, no);
			System.out.println("Enter your employee Name:");
			String name=sc.next();
			pre.setString(2, name);
			System.out.println("Enter your employee age:");
			int age=sc.nextInt();
			pre.setInt(3, age);
			result=pre.execute();
			if(result!=true) 
				System.out.println("Data sucessfully inserted...");
			
			else 
				System.out.println("Data not inserted...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Jdbccrudoperations obj=new Jdbccrudoperations();
		obj.insert();
		
	}

}
