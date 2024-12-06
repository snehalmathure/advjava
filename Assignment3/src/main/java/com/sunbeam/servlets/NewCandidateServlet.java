package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.Candidate;
import com.sunbeam.entities.User;




@WebServlet("/newcandidate")
public class NewCandidateServlet extends HttpServlet {
	
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
		
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		int votes=0;
		
		int count=0;
		Candidate candidate = new Candidate(0,name,party,votes);
		try(CandidateDao candao= new CandidateDaoImpl())
		{
			
			count=candao.save(candidate);		
		}
	
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate</title>");
		out.println("</head>");
		out.println("<body>");
		if(count>0)
		{
			
				resp.sendRedirect("result");
				
		}
		else
		{
			out.println("<h2>Failed to add new Candidate<h2>");
			
			
			out.println("<p><a href='newcandidate.html'>back to add Canddiate</a></p>");
			
		}
		out.println("</body>");
		out.println("</html>");
	}

	
}
