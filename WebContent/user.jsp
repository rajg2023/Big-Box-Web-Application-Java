<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,business.bigbox.web.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Users Page</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
</head>
<body>
	<ol>
		<li><a class="active" href="index.html">Log In</a></li>
		<li><a class="active" href="index.html">Log Out</a></li>
		<li><a class="active" href="home.html">Home</a></li>
		<li><a class="active" href="application.html">BigBoxApp</a></li>
		<li style="float: right"><a href="contact.html">Contact Me</a></li>
	</ol>
	<center>
		<h1>
			<b><u>Welcome to the Big Box Web Application</u>
		</h1>
		<h2>List of all the Users</h2>
		<table>
			<tr>
				<th>User Name</th>
				<th>Password</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Email</th>
			</tr>
			<%
				ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
				System.out.println(users.size());
				for (User u : users) {
					System.out.println("UserName: " + u.getUserName() + "Password: " + u.getPassword() + "FirstName:"
							+ u.getFirstName() + "LastName:" + u.getLastName() + "Phone#:" + u.getPhone() + "Email:"
							+ u.getEmail());
			%>
			<tr>
				<td><%=u.getUserName()%></td>
				<td><%=u.getPassword()%></td>
				<td><%=u.getFirstName()%></td>
				<td><%=u.getLastName()%></td>
				<td><%=u.getPhone()%></td>
				<td><%=u.getEmail()%></td>
			</tr>
			<%
				}
			%>		
		</table>
		<input action="action" onclick="history.go(-1);" type="button" value="Back"/>
	</center>
	<footer> <marquee>Copyright &copy; 2017 R@jiv Giri</marquee> </footer>
</body>
</html>