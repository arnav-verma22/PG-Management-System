package com.arnav.verma;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

class ActionDAO
{
	private Connection con;
	public static String getStringValue(HashMap<String, String> map, String v)
	{
		for(Map.Entry<String, String> m : map.entrySet())
		{
			if(m.getKey().equalsIgnoreCase(v))
			{
				return m.getValue();
			}
		}
		return null;
	}
	public static Integer getIntegerValue(HashMap<String, Integer> map, String v)
	{
		for(Map.Entry<String, Integer> m : map.entrySet())
		{
			if(m.getKey().equalsIgnoreCase(v))
			{
				return m.getValue();
			}
		}
		return 0;
	}
	public ActionDAO(Connection con)
	{
		this.con = con;
	}
	
	public ArrayList<Pg> FilterSearch(HashMap<String, String> str, HashMap<String, Integer> ints) throws SQLException 
	{
		String room = null, address = null, gen = null;
		int price = Integer.MAX_VALUE, seater = 10;
		if(getStringValue(str, "room") != null)
		{
			room = getStringValue(str, "room");
		}
		if(getStringValue(str, "address") != null)
		{
			address = getStringValue(str, "address");
		}
		if(getStringValue(str, "gen") != null)
		{
			gen = getStringValue(str, "gen");
		}
		if(getIntegerValue(ints, "price") != 0)
		{
			price = getIntegerValue(ints, "price");
		}
		if(getIntegerValue(ints, "seater") != 0)
		{
			seater = getIntegerValue(ints, "seater");
		}
		ArrayList<Pg> list = new ArrayList<Pg>();
		ResultSet rs = null;
		String query = "select * from pg where pg.price < " + price + " and pg.seater <= " + seater;
		if(address != null)
		{
			query += " and pg.address like '%" + address + "%' ";
		}
		if(gen != null)
		{
			query += " and pg.gen like '%" + gen + "%' ";
		}
	
		if(room != null && room.equalsIgnoreCase("N"))
		{
			query += " and pg.room like '%N%' ";
		}
		else if(room != null && !room.equalsIgnoreCase("N"))
		{
			query += " and pg.room not like '%N%' ";
		}
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
		}
		while(rs.next())
		{
			Pg pg = new Pg();
			pg.setName(rs.getString("Name"));
			pg.setContact(rs.getString("contact"));
			pg.setAddress(rs.getString("address"));
			pg.setRoom(rs.getString("room"));
			pg.setGen(rs.getString("gen"));
			pg.setSeater(rs.getInt("seater"));
			pg.setPrice(rs.getInt("price"));
			pg.setEmail(rs.getString("email"));
			list.add(pg);
		}
		return list;
		
	}
	public ArrayList<Pg> Search() throws SQLException 
	{
		ArrayList<Pg> list = new ArrayList<Pg>();
		ResultSet rs = null;
		String query = "select * from pg";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Pg pg = new Pg();
			pg.setName(rs.getString("Name"));
			pg.setContact(rs.getString("contact"));
			pg.setAddress(rs.getString("address"));
			pg.setRoom(rs.getString("room"));
			pg.setGen(rs.getString("gen"));
			pg.setSeater(rs.getInt("seater"));
			pg.setPrice(rs.getInt("price"));
			pg.setEmail(rs.getString("email"));
			list.add(pg);
		}
		return list;
	}
	public ArrayList<Pg> Search(String email) throws SQLException
	{
		ArrayList<Pg> list = new ArrayList<Pg>();
		ResultSet rs = null;
		String query = "select * from pg where email = '" + email + "'";
		
		if(this.con != null)
		{
			Statement st = con.createStatement();
			rs = st.executeQuery(query);
			//System.out.println(rs);
		}
		while(rs.next())
		{
			Pg pg = new Pg();
			pg.setName(rs.getString("Name"));
			pg.setContact(rs.getString("contact"));
			pg.setAddress(rs.getString("address"));
			pg.setRoom(rs.getString("room"));
			pg.setGen(rs.getString("gen"));
			pg.setSeater(rs.getInt("seater"));
			pg.setPrice(rs.getInt("price"));
			pg.setEmail(email);
			list.add(pg);
		}
		return list;
	}
	public void Insert(String name, String num, String room, String address, String gen, int price, int seater, String email) throws SQLException
	{
		String query = "insert into pg values(?,?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, name);
		pst.setString(2, num);
		pst.setString(3, room);
		pst.setInt(4, price);
		pst.setString(5, gen);
		pst.setString(6, address);
		pst.setInt(7, seater);
		pst.setString(8, email);
		pst.executeUpdate();
	}
}