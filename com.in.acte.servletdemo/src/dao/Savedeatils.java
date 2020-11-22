package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import model.user;

public class Savedeatils {

	static final String jdbc_driver="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost/sys";
	static final String user="root";
	static final String pwd="World!1";
	static Connection con=null;
	static PreparedStatement pre=null;
	
	public Boolean save(user obj) {
try {
			
				Class.forName(jdbc_driver);
				System.out.println("selected database");
				con=DriverManager.getConnection(Db_url,user,pwd);
				System.out.println("Connected database successfully");
				PreparedStatement pre=con.prepareStatement("insert into test values(?,?)");
			
			pre.setString(1,obj.getName());
			pre.setString(2, obj.getEmailid());
			
			int re=pre.executeUpdate();
			
			
			if(re==1){
				return true;
			}else{
				return false;	
			}
		} catch (Exception e) { 
			e.printStackTrace();
			return false;
		}	
		
	}

}
