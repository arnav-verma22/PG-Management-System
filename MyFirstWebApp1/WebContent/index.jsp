<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<div style="text-align:center;">
		<h1>Login Page</h1>
		<%
			//if(session.getAttribute("user") != null)
			//{
				//response.sendRedirect("Searchserv");
			//}
		//out.println(request.getParameter("add") + "<br>");
		//out.println(request.getParameter("login") + "<br>");
		if(request.getParameter("add") != null || request.getParameter("my") != null)
		{
			session.setAttribute("add", request.getParameter("add"));
			session.setAttribute("my", request.getParameter("my"));
		}
		%>
		<form action="MyLoginServlet" method="get">
			<input type="text" placeholder="Enter your username" name="username"/><br>
			<input type="password" placeholder="Enter your password" name="pass"/><br>
			<input type="submit" value="login" name="login"/>
			<input type="reset" value="Reset"/>
			<p>
			<%
				
				if(request.getAttribute("Arnav") != null)
				{	
					out.println(request.getAttribute("Arnav"));
				}
			%>
			</p>
		</form>
	</div>
</body>
</html>