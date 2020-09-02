package com.arnav.verma;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyPgs
 */
@WebServlet("/MyPgs")
public class MyPgs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPgs() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user") != null && (request.getParameter("add") != null || session.getAttribute("add") != null))
		{
			session.setAttribute("add", null);
			response.sendRedirect("NewPg.jsp");
		}
		else if(session.getAttribute("user") != null && (request.getParameter("my") != null || session.getAttribute("my") != null) )
		{
			//session.setAttribute("my", null);
			//response.sendRedirect("Searchserv");
			RequestDispatcher rd  = request.getRequestDispatcher("Searchserv");
			rd.forward(request, response);
		}
		else
		{
			//response.sendRedirect("index.jsp");
			RequestDispatcher rd  = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
//		request.getParameter("add");
//		request.getParameter("my");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
