<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,business.bigbox.web.Store"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="main.css">
<title>Get Store list</title>
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Stores Page</title>
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
		<h2>List of all the Stores</h2>
		<table>
			<tr>
				<th>DivisionID</th>
				<th>Store#</th>
				<th>Name</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>ZipCode</th>
			</tr>
			<%
				ArrayList<Store> stores = (ArrayList<Store>) request.getAttribute("stores");
				System.out.println(stores.size());
				for (Store s : stores) {
					System.out.println("DivisionID: " + s.getDivisionID() + "Store#: " + s.getStoreNumber() + "Store Name:"
							+ s.getName() + "Store Address:" + s.getAddress() + "City:" + s.getCity() + "State:"
							+ s.getState() + "ZipCode:" + s.getZipCode());
			%>
			<tr>
				<td><%=s.getDivisionID()%></td>
				<td><%=s.getStoreNumber()%></td>
				<td><%=s.getName()%></td>
				<td><%=s.getAddress()%></td>
				<td><%=s.getCity()%></td>
				<td><%=s.getState()%></td>
				<td><%=s.getZipCode()%></td>
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