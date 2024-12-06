package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;


@WebServlet("/signup")
public class RegistrationServlet extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}

	private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text.html");
		PrintWriter out =resp.getWriter();
		
		String firstName=req.getParameter("fname");
		String lastName=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("passwd");
		String birthdate=req.getParameter("DOB");
		Date DOB=Date.valueOf(birthdate);
		int status=0;
		String role="voter";
		int count=0;
		User user = new User(0,firstName,lastName,email,password,DOB,status,role);
		try(UserDao userdao= new UserDaoImpl())
		{
			
			
			count=userdao.save(user);	
//			user= userdao.findByEmail(email);
//			if(user.getEmail().equals(email))
//			{
//				
//				
//				out.println("<html>");
//				out.println("<head>");
//				out.println("<title>signup</title>");
//				out.println("</head>");
//				out.println("<body>");
//				out.println("<h2>user alredy exists</h2>");
//				
//			
//				out.println("</body>");
//				out.println("</html>");
//				
//			
//			}
//			
//			else
//			{
				
//			}
	
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>registration</title>");
		out.println("</head>");
		out.println("<body>");
		if(count>0)
		{
			
				out.println("<h2>Registered Successfully");
				out.println("<br/><br/>");
				
				out.println("<a href='index.html'>Back to Login</a>");
			
		}
		else
		{
			out.println("<h2>Registration Failed");
			
			
			out.println("<p><a href='newuser.html'>Go to Registration</a></p>");
			
		}
		out.println("</body>");
		out.println("</html>");
	}
}
