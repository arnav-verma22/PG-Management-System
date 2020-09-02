package com.arnav.verma;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

import com.mysql.cj.xdevapi.Statement;


public class MyDBConnection 
{
	static final String driver = "com.mysql.jdbc.Driver";
	static String db = "jdbc:mysql://localhost/mydb";
	private static String user = "root";
	private static String pass = "22@ugust";
	
	public static Connection GetConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(driver);
		Connection con = DriverManager.getConnection(db,user,pass);
		return con;
//		String query = "insert into pg values('Praj', '7084329329', 'jaipur', 'NAC Rooms', 'given Wifi')";
//		java.sql.Statement st = con.createStatement();
//		int count = st.executeUpdate(query);
//		System.out.println(count + " rows affected");
//		st.close();
//		con.close();
	}
	public static void CloseConnection(Connection con) throws SQLException 
	{
		con.close();
		//PreparedStatement pst = con.prepareStatement("insert into pg values(?,?,?,?,?)");
	}
}
