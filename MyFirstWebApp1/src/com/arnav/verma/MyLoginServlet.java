	package com.arnav.verma;
	
	import java.io.IOException;
	import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import javax.servlet.http.HttpSession;
	
	@WebServlet("/MyLoginServlet")
	public class MyLoginServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	
	    public MyLoginServlet() {
	        super();
	    }
	
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			PrintWriter out = response.getWriter();
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			HttpSession session = request.getSession();
			session.setAttribute("user", username);
			session.setAttribute("pass", password);
			Connection con = null;
			try {
				con = MyDBConnection.GetConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			LoginDAO login = new LoginDAO(con);
			try {
				if(login.Check(username, password))
				{
		
					response.sendRedirect("MyPgs");
					out.println("hello world !!");
				}
				else
				{
					RequestDispatcher rd  = request.getRequestDispatcher("index.jsp");
					request.setAttribute("Arnav", "Sorry username or password is incorrect");
					rd.forward(request, response);
					
					
					//out.println("Sorry username or password is incorrect");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				MyDBConnection.CloseConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().append("Served at post: ").append(request.getContextPath());
			doGet(request, response);
		}
	
	}
