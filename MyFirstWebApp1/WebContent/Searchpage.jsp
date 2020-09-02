<%@page import="com.arnav.verma.Pg"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search PGs</title>
</head>
<body>
	<%
		String my = null;
		if(session.getAttribute("my") != null)
			my = session.getAttribute("my").toString();
	%>
	<c:if test="${my == null}">
	<h1>PG's Available</h1>
	</c:if>
	<c:if test="${my != null}">
	<h1>Your PGs</h1>
	</c:if>
	<c:if test="${my == null}">
	<form action="FilterServ">
	<select name="city" id="city">
		<option value="null" selected disabled>Select City</option>
		
		<c:forEach items ="${list}" var="Pg">
			<option value="${Pg.name}">${Pg.name}</option>
		</c:forEach>
		<option value="jaipur">Jaipur</option>
  		<option value="Vellore">Vellore</option>
  		<option value="lucknow">Lucknow</option>
  		<option value="Pune">Pune</option>
	</select>
	<select name="room" id="room">
		<option value="null" selected disabled>Select Room type</option>
		<option value="AC">AC</option>
  		<option value="NA">N-AC</option>
	</select>
	<select name="gen" id="gen">
		<option value="null" selected disabled>PG for</option>
		<option value="boys">Boys</option>
  		<option value="girls">Girls</option>
	</select>
	  <select name="seater" id="seater">
		<option value= 0 selected>No. of beds</option>
		<option value= 1>1</option>
		<option value= 2>2</option>
		<option value= 3>3</option>
  		<option value= 4>4</option>
	</select>
	
	<input value= 0 type="text" placeholder="Budget " name="price"/>	
	
		<input type="submit" value="Search"><br><br>
	</form>
	</c:if>
	
	<%
		ArrayList<Pg> list1 = (ArrayList<Pg>)session.getAttribute("list");
		for(Pg pg:list1)
		{
			out.println("Owner's Name: " + pg.getName() + "<br>");
			out.println("Contact: " + pg.getContact() + "<br>");
			out.println("City: " + pg.getAddress() + "<br>");
			out.println("Room Type: " + pg.getRoom() + "<br>");
			out.println("Price: " + pg.getPrice() + "<br>");
			out.println("<br><br><br>");
		}
		if(list1.size() == 0)
		{
			out.println("Sorry No PGs available, try reducing filters..");
		}
					
	%>
	<c:if test="${my != null}">
		<form action="Modifyserv" >
			<input type="submit" value="Modify" name="modify"/>
		</form>
	</c:if>
	<% session.setAttribute("my", null); %>
</body>
</html>