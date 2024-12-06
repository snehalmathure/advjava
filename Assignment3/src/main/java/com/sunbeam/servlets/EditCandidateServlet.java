package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;



@WebServlet("/editcand")
public class EditCandidateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(req,resp);
	}
	

	private void processRequest(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String candId=req.getParameter("id");
		int id = Integer.parseInt(candId);
		
		
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit</title>");
		out.println("</head>");
		out.println("<body>");
		
		ServletContext app = this.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		out.println("<h2>Edit Candidate</h2>");
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			
			Candidate c=candao.findById(id);
			
			if(c!=null)
			{
				
				out.println("<form method='post' action='editcand'>");
				out.printf("Id: <input type='hidden' name='id' value='%d'/><br/><br/>",c.getId());
				out.printf("Name: <input type='text' name='name' value='%s'/><br/><br/>",c.getName());
				out.printf("party: <input type='text' name='party' value='%s'/><br/><br/>",c.getParty());
				out.printf("Votes: <input type='text' name='vote' value='%d' readonly/><br/><br/>",c.getVotes());
				out.printf("<input type='submit'  value='Updated'/><br/><br/>");
				out.println("</form>");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String candid=req.getParameter("id");
		int id=Integer.parseInt(candid);
		String name=req.getParameter("name");
		String party=req.getParameter("party");
		int votes=Integer.parseInt(req.getParameter("vote"));
		
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		
		Candidate cand=new Candidate(id,name,party,votes);
		try(CandidateDao candao = new CandidateDaoImpl())
		{
			
			int count = candao.update(cand);
			if(count == 1)
			{
				String message="Candiate Updated: "+count;
				req.setAttribute("msg",message);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		RequestDispatcher rd =req.getRequestDispatcher("result");
		rd.forward(req, resp);
	}
	
}
