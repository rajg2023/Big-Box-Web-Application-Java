<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList,business.bigbox.web.Division"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>division page</title>
<link rel="stylesheet" type="text/css" href="main.css">
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
		<h2>List of all the Stores</h2>
		<table>
			<tr>
				<th>Division#</th>
				<th>Name</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
				<th>ZipCode</th>
			</tr>
			<%
				ArrayList<Division> divisions = (ArrayList<Division>) request.getAttribute("divisions");
				System.out.println(divisions.size());
				for (Division d : divisions) {
					System.out.println("Division#: " + d.getDivisionNumber() + "Division Name:" + d.getName()
							+ "Division Address:" + d.getAddress() + "City:" + d.getCity() + "State:" + d.getState()
							+ "ZipCode:" + d.getZipCode());
			%>
			<tr>
				<td><%=d.getDivisionNumber()%></td>
				<td><%=d.getName()%></td>
				<td><%=d.getAddress()%></td>
				<td><%=d.getCity()%></td>
				<td><%=d.getState()%></td>
				<td><%=d.getZipCode()%></td>
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