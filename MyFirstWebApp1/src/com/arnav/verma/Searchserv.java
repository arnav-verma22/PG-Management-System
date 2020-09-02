package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

/**
 * Servlet implementation class Searchserv
 */
@WebServlet("/Searchserv")
public class Searchserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Searchserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Connection con = null;
		ArrayList<Pg> thelist = null;
//		System.out.println(request.getParameter("customer") + "<br>");
//		System.out.println(session.getAttribute("my") + "<br>");
		try {
			con = MyDBConnection.GetConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		ActionDAO act = new ActionDAO(con);
		
		if(request.getParameter("my") != null)
		{
			session.setAttribute("my", request.getParameter("my"));
			System.out.println(request.getParameter("my"));
		}
		
		if(session.getAttribute("my") == null)
		{
			try {
				 thelist = act.Search();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			
		if(session.getAttribute("my") != null)
		{
			try {
				System.out.println(session.getAttribute("user"));
				thelist = act.Search(session.getAttribute("user").toString());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		session.setAttribute("list", thelist);
		
		out.println("Search complete");
		try {
			MyDBConnection.CloseConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect("Searchpage.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
