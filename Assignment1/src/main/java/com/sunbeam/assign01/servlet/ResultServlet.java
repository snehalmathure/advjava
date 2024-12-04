package com.sunbeam.assign01.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.assign01.entities.Marks;



@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet{
	
	private ArrayList<Marks> result;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		result=new ArrayList();
		result.add(new Marks("Java Programming",90));
		result.add(new Marks("Database",80));
		result.add(new Marks("Operatin System",70));
		result.add(new Marks("Web Programming",80));
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		out.println("<html>");
			out.println("<head>");
				out.println("<title>Result</title>");
			out.println("</head>");
				out.println("<body>");
				out.println("<h1 >Result</h1>");
					out.println("<table>");
						out.println("<thead>");
							out.println("<th>");
								out.println("<tr>");
		
									out.println("<th>Subject</th>");
									out.println("<th>Marks</th>");
		
								out.println("</tr>");
							out.println("</th>");
						out.println("</thead>");
						out.println("<tbody>");
		
							for(Marks m: result)
							{
									out.println("<tr>");
										out.printf("<td>%s<td>\r\n", m.getSub());
										out.printf("<td>%.2f<td>\r\n", m.getMarks());
									out.println("</tr>");
							}
						out.println("</tbody>");
					out.println("</table>");
				out.println("</body>");
		out.println("</html>");
	}
}
