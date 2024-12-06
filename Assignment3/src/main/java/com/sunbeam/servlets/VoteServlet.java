package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.entities.User;


@WebServlet("/Vote")
public class VoteServlet extends HttpServlet {
	
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

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String candId=req.getParameter("candidate");
		int id= Integer.parseInt(candId);
		
		resp.setContentType("text/html");
		PrintWriter out= resp.getWriter();
		
		
		ServletContext appColor=this.getServletContext();
		String color = appColor.getInitParameter("app.color");
		
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Result</title>");
		out.println("</head>");
		out.printf("<body bgcolor='%s'>",color);
		
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
		
		
		out.println("<h2>Voting Status</h2>");
		
//		try(CandidateDao candao = new CandidateDaoImpl())
//		{
//		
//			int count=candao.incrVote(id);
//			if(count==1)
//			{
//				out.println("<h4>You have successfully casted your Vote.</h4>");
//			}
//			else
//			{
//				out.println("<h4>Your voting is failed");
//			}
			
			//HttpSession session=req.getSession();
			HttpSession session=req.getSession(false);
			if(session==null)
				
			{
				resp.sendRedirect("index.html");
				//resp.sendError(440);
				return;
			}
		
			User user=(User) session.getAttribute("curuser");
			
			
			if(user.getStatus()==0)
			{
				try(CandidateDao candao = new CandidateDaoImpl())
				{
				
					int count=candao.incrVote(id);
					if(count==1)
						{
							out.println("<h4>You have successfully casted your Vote.</h4>");
							user.setStatus(1);
							try(UserDao userdao=new UserDaoImpl())
							{
								count=userdao.update(user);
								if (count==1)
								{
									out.println("<h4>You are marked as Voted.</h4>");
								}
							}
						}
					else
					{
						out.println("<h4>Your voting is failed");
					}
					
				}
			
						catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						throw new ServletException(e);
						}
			}
				
			else
				{
				out.println("<h4>You have alredy Voted.</h4>");
				}
		out.println("<a href='logout'>logout</a>");
		out.println("</body>");
		out.println("</html>");
		
	}

		
}
