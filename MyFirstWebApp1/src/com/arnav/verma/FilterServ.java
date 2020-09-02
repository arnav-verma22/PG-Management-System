package com.arnav.verma;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FilterServ
 */
@WebServlet("/FilterServ")
public class FilterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FilterServ() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//PrintWriter out = response.getWriter();
		Connection con = null;
		ArrayList<Pg> thelist = null;
		HashMap<String, String> str = new HashMap<String, String>();
		HashMap<String, Integer> ints = new HashMap<String, Integer>();
		String room = request.getParameter("room");
		String address = request.getParameter("city");
		String gen = request.getParameter("gen");
		int seater = Integer.parseInt(request.getParameter("seater"));
		int price = Integer.parseInt(request.getParameter("price"));
		System.out.println(room + ", " + address + ", " + gen + ", " + price + ", " + seater);
		if(room != null)
			str.put("room", room);
		if(address != null)
			str.put("address", address);
		if(gen != null)
			str.put("gen", gen);
		if(price != 0)	
			ints.put("price", price);
		if(seater != 0)
			ints.put("seater", seater);

		try {
			con = MyDBConnection.GetConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		ActionDAO act = new ActionDAO(con);
		
		 try {
			thelist = act.FilterSearch(str, ints);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		session.setAttribute("list", thelist);
		response.sendRedirect("Searchpage.jsp");
		//System.out.println(room + ", " + address + ", " + gen + ", " + price + ", " + seater);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
