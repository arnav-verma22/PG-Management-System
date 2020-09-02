package com.arnav.verma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class LoginDAO
{
	private Connection con;

	public LoginDAO(Connection con) 
	{
		this.con = con;
	}
	public boolean Check(String username, String password) throws SQLException
	{
		String query = "select * from login where email = '" + username + "' and password = '" + password + "';";
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		if (rs.next())
		{
			return true;
		}
		else
			return false;
	}
	public void CreateAccount(String username , String password) throws SQLException 
	{
		String query = "insert into login values('"+ username + "', '" + password + "';";
		Statement st = con.createStatement();
		st.executeUpdate(query);
	}
	
}