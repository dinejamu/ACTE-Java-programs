package com.in.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	
	public void delete() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,username,password);
			String query="delete from employee where empno=?";
			pre=con.prepareStatement(query);
			System.out.println("Enter your Employee no");
			int no=sc.nextInt();
			pre.setInt(1, no);
			pre.execute();
			System.out.println("Data sucessfully Deleted...");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void update() {
	
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,username,password);
			String query="update employee set age=?, empname=? where empno=?";
			pre=con.prepareStatement(query);
			System.out.println("Enter your employee no: ");
			int no=sc.nextInt();
			pre.setInt(3, no);
			System.out.println("please enter your age: ");
			int age=sc.nextInt();
			pre.setInt(1, age);
			System.out.println("please enter your name: ");
			String name=sc.next();
			pre.setString(2, name);
			pre.executeUpdate();
			System.out.println("Data updated..");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void select() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(dburl,username,password);
			String query="select * from employee;";
			pre=con.prepareStatement(query);
			ResultSet result=pre.executeQuery();
			while(result.next()) {
				int no=result.getInt("empno");
				String name=result.getString("empname");
				int age=result.getInt("age");
				System.out.println(no+" "+name+" "+age);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String[] args) {
		Jdbccrudoperations obj=new Jdbccrudoperations();
		//obj.insert();
		//obj.delete();
		//obj.update();
		obj.select();
	}

}
