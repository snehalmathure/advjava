package com.sunbeam.assign01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<Title>Home</title>");
		out.println("</head>");
		out.println("<body bgcolor='pink'>");
		out.println("<h1>Profile</h1>");
		out.println("<h3>FirstName: Snehal</h3>");
		out.println("<h3>lastName: Mathure</h3>");
		out.println("<h3>Qualification: B.Tech</h3>");
		out.println("<h3>College: SIT</h3>");
		out.println("<h3>Univercity: DBATU</h3>");
		out.println("<h3>birthDate: 06/08/2001</h3>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
