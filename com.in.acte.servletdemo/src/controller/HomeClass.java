package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Savedeatils;
import model.user;



@WebServlet("/HomeClass")
public class HomeClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String mailid=request.getParameter("email");
		
		user obj=new user();
		obj.setName(name);
		obj.setEmailid(mailid);
		
		Savedeatils ob=new Savedeatils();
		ob.save(obj);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
