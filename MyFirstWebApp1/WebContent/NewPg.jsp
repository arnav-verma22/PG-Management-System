<%@page import="com.arnav.verma.Pg"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewPg</title>
</head>
<%
	
	String req = null;
	req = request.getParameter("modifythis");
	String se = session.getAttribute("modifythis").toString();
	out.println(req + se);
%>
<body>
	<div style="text-align:center;">
	<c:if test="${req != se}">
	<%out.println(req); %>
	<h1>Add Details</h1>
		<form action="AddServ" method="get">
			<input type="text" placeholder="Enter your name" name="name"/><br>
			<input type="text" placeholder="Enter your Contact No." name="num"/><br>
			<input type="text" placeholder="Enter the Address" name="address"/><br>
			<input type="text" placeholder="Room type AC/N-AC" name="room"/><br>
			<input type="text" placeholder="Pg for boys/girls" name="gen"/><br>
			<input type="number" placeholder="Price of PG" name="price"/><br>
			<input type="number" placeholder="No. of beds" name="seater"/><br>
			<input type="submit" value="Add"/>
		</form>
	</c:if>
	<c:if test="${req == se}">
	<h1>Modify Details</h1>
		<form action="Modifyserv" method="get">
		<c:forEach items="${list1}" var="Pg">
			<input value= "${Pg.name}"  type="text" placeholder="Enter your name" name="name"/><br>
			<input value= "${Pg.contact}" type="text" placeholder="Enter your Contact No." name="num"/><br>
			<input value= "${Pg.address}"  type="text" placeholder="Enter the Address" name="address"/><br>
			<input value= "${Pg.room}" type="text" placeholder="Room type AC/N-AC" name="room"/><br>
			<input value= "${Pg.gen}" type="text" placeholder="Pg for boys/girls" name="gen"/><br>
			<input value= "${Pg.price}" type="number" placeholder="Price of PG" name="price"/><br>
			<input value= "${Pg.seater}" type="number" placeholder="No. of beds" name="seater"/><br>
		</c:forEach>	
			<input type="submit" value="Modify"/>
		</form>
	</c:if>
		
	</div>
</body>
</html>