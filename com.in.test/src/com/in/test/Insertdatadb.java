package com.in.test;

import java.sql.*;

import java.util.Scanner;


public class Insertdatadb {
	Scanner sc=new Scanner(System.in);
	static final String jdbc_driver="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost/sys";
	static final String user="root";
	static final String pwd="World!1";
	static Connection con=null;
	static PreparedStatement pre=null;
	static Statement stm;
	static String query=null;
	
	public void insert() {
		try {
			Scanner sc=new Scanner(System.in);
			Class.forName(jdbc_driver);
			System.out.println("selected database");
			con=DriverManager.getConnection(Db_url,user,pwd);
			System.out.println("Connected database successfully");
			String query="insert into info (firstname,age,location) values(?,?,?)";
			pre=con.prepareStatement(query);
			System.out.println("Enter your Name:");
			String name=sc.next();
			pre.setString(1, name);
			System.out.println("Enter your Age:");
			int age=sc.nextInt();
			pre.setInt(2, age);
			System.out.println("Enter your Location:");
			String loc=sc.next();
			pre.setString(3, loc);
			boolean res=pre.execute();
			if(res==false)
			System.out.println("suceessfully inserted.....");
			else
				System.out.println("Try again");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void selectall() {
		try {
			Class.forName(jdbc_driver);
			System.out.println("selected database");
			con=DriverManager.getConnection(Db_url,user,pwd);
			System.out.println("Connected database successfully");
			String query="select * from info;";
			stm=con.createStatement();
			ResultSet rs=stm.executeQuery(query);
			while(rs.next()) {
				String name=rs.getString("firstname");
				int age=rs.getInt("age");
				String loc=rs.getString("location");
				System.out.println(name+"  "+age+"  "+loc+"  ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public void update() {
		
		try {
			Class.forName(jdbc_driver);
			System.out.println("selected database");
			con=DriverManager.getConnection(Db_url,user,pwd);
			System.out.println("Connected database successfully");			
			query="update info set age=?, location=? where firstname=?;";	
			pre=con.prepareStatement(query);
			System.out.println("Enter your Name for Update:");	
			String name=sc.next();
			pre.setString(3, name);	
			System.out.println("update your Age:");
			int age=sc.nextInt();
			pre.setInt(1, age);
			System.out.println("update your Location:");
			String loc=sc.next();
			pre.setString(2, loc);				
			int res=pre.executeUpdate();
			if(res==1) {
				System.out.println("records update success..");			
				}
			else {
				System.out.println("Invaild Details");
			}
		}
		 catch (Exception e) {		
			e.printStackTrace();
		}
		finally {		
			try {
				System.out.println("updated Record Details");
				String query="select * from info;";
				stm=con.createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {
					String name1=rs.getString("firstname");
					int age1=rs.getInt("age");
					String loc1=rs.getString("location");
					System.out.println(name1+"  "+age1+"  "+loc1+"  ");
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public void delete() {
		try {
			Class.forName(jdbc_driver);
			System.out.println("selected database");
			con=DriverManager.getConnection(Db_url,user,pwd);
			System.out.println("Connected database successfully");			
			query="delete from info where firstname=?;";
			pre=con.prepareStatement(query);
			System.out.println("Enter the Name for Delete:");	
			String name=sc.next();
			pre.setString(1, name);
			int res=pre.executeUpdate();
			if(res==1) {
				System.out.println("Record Deleted!!!");
			}
			else {
				System.out.println("Try again After same Time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {		
			try {
				System.out.println("updated Record Details");
				String query="select * from info;";
				stm=con.createStatement();
				ResultSet rs=stm.executeQuery(query);
				while(rs.next()) {
					String name1=rs.getString("firstname");
					int age1=rs.getInt("age");
					String loc1=rs.getString("location");
					System.out.println(name1+"  "+age1+"  "+loc1+"  ");
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
		public static void main(String[] args) {
		Insertdatadb obj=new Insertdatadb();
		//obj.insert();
		obj.selectall();
		//obj.update();
		//obj.delete();

	}

}
