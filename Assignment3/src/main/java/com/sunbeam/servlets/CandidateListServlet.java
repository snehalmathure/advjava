package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;


@WebServlet("/candList")
public class CandidateListServlet extends HttpServlet {
	
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
		
		List<Candidate> list = new ArrayList<>();
		
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			list = candao.findAll();

		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		ServletContext appColor=this.getServletContext();
		String color = appColor.getInitParameter("app.color");
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>",color);
		
		
		// get app title from ctx param and display it
				ServletContext app = this.getServletContext();
				String appTitle = app.getInitParameter("app.title");
				out.printf("<h1>%s</h1>", appTitle);
		
		Cookie [] arr=req.getCookies();
		String userName="";
		String role="";
		
		if(arr!=null)
		{
			for(Cookie c: arr)
			{
				if(c.getName().equals("uname"))
				{
					userName=c.getValue();
				}
				if(c.getName().equals("role"))
				{
					role=c.getValue();
				}
					
			}
		}
		
		out.printf("Hello, %s (%s)<hr/>\n", userName, role);
		
		ServletContext ctx=req.getServletContext();
		String announcment= (String)ctx.getAttribute("ann");
		
		if(announcment!=null)
		{
			out.println("<p style='color:red'>Note:"+announcment+"</p>");
		}
		
		
		
		out.println("<form method='post' action='Vote'>");
		for(Candidate c: list)
		{
			out.printf("<input type='radio' name='candidate' value='%d'/>%s<br/>",c.getId(),c.getName());
		}
		out.println("<br/><input type='submit' value='vote'/>");
		
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	
			

}
}
