package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;




@WebServlet("/deletecand")
public class DeleteCandidateServlet extends HttpServlet {

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
		
		String candId=req.getParameter("id");
		int id=Integer.parseInt(candId);
		int count=0;
		try(CandidateDao candao =new CandidateDaoImpl())
		{
			
			count=candao.deleteById(id);
			if(count==1)
			{
				String message="Candidate Deleted!";
				req.setAttribute("msg",message);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException(e);
		}
		// go back to result servlet
			RequestDispatcher rd=req.getRequestDispatcher("result");
			rd.forward(req,resp);
		
	}
}
