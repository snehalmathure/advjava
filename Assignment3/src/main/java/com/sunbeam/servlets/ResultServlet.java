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


@WebServlet("/result")
public class ResultServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req, resp);
	}
	
	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException ,IOException {
		// TODO Auto-generated method stub
		
		List<Candidate> list=new ArrayList<>();
		
		try(CandidateDao candao=new CandidateDaoImpl())
		{
			list = candao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.println("<body>");
		
		
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
		
		out.println("<h2>Voting Result</h2>");
		out.println("<table border='1'>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Candidate c : list) {
			out.println("<tr>");
			out.printf("<td>%d</td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.printf("<td>%d</td>\n", c.getVotes());
			out.printf("<td>\n");
			out.printf("<a href='editcand?id=%d'><img src='images/edit.png' alt='Edit' width='24' height='24'/></a>",c.getId());
			out.printf("<a href='deletecand?id=%d'><img src='images/delete.png' alt='Delete' width='24' height='24'/></a>",c.getId());
			out.printf("</td>");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		
		String message=(String)req.getAttribute("msg");
		if(message!=null)
		{
			out.println("<p>" + message + "</p>");
		}
		
		out.println("<p><a href='newcandidate.html'>add Candidate</a></p>");
		out.println("| <a href='Announcement.html'>Announce</a>");
		out.println("<p><a href='logout'>Sign Out</a></p>");
		
		
		
		out.println("</body>");
		out.println("</html>");

		
		
	}
	

}
