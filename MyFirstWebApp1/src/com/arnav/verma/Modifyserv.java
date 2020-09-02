package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class Modifyserv
 */
@WebServlet("/Modifyserv")
public class Modifyserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Modifyserv() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(request.getParameter("modify") != null)
			response.sendRedirect("ModifyPage.jsp");
		ArrayList<Pg> list = (ArrayList<Pg>)session.getAttribute("list");
		ArrayList<Pg> list1 = new ArrayList<Pg>();
		if(request.getParameter("modifythis") != null)
		{
			for (Pg pg : list) 
			{
				if(pg.getAddress().equalsIgnoreCase(request.getParameter("address")))
				{
					
					System.out.println("found");
					list1.add(pg);
					break;
				}
				else
					System.out.println("not matched");
			}
			session.setAttribute("list1", list1);
			session.setAttribute("modifythis", request.getParameter("modifythis"));
			RequestDispatcher rd  = request.getRequestDispatcher("NewPg.jsp");
			rd.forward(request, response);
			
		}
			out.println(request.getParameter("addresss"));
			out.println(request.getParameter("num"));
			out.println(request.getParameter("price"));
			out.println(request.getParameter("name"));
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
