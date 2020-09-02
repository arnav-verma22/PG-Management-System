<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<h1>Modify your PGs</h1>
		
		<form action="Modifyserv" >
			<c:forEach items="${list}" var="Pg">
			<input type="radio"  placeholder="Enter the Address" name="address" value="${Pg.address}"/>${Pg.address}<br>
			<input type="hidden"  placeholder="Enter your name" value="${Pg.name }" name="name"/>${Pg.name}<br>
			<input type="hidden" name="num"/>${Pg.contact}<br>
			<input type="hidden" placeholder="Room type AC/N-AC" name="room"/>${Pg.room}<br>
			<input type="hidden" placeholder="Pg for boys/girls" name="gen"/>${Pg.gen}<br>
			<input type="hidden" placeholder="Price of PG" name="price"/>${Pg.price}<br>
			<input type="hidden" placeholder="No. of beds" name="seater"/>${Pg.seater}<br>
			
			</c:forEach>
			<input type="submit" value="Modify" name="modifythis"/>
		</form>
</body>
</html>