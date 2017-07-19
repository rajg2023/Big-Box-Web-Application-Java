<%@page import="storesales.bigbox.web.StoreSalesDAO"%>
<%@page import="db.bigbox.web.StoreSalesDB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page
	import="java.util.ArrayList,business.bigbox.web.Store,business.bigbox.web.StoreSales,java.text.NumberFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="main.css">
<style>
table, th, td {
	border: 1px solid black;
}
</style>
<title>Store Sales Page</title>
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
		<h2>List of all the Stores Sales</h2>
		Sales for store ${storeID} = ${sales}<br>
		<table>
			<tr>
				<th>StoreID</th>
				<th>Year</th>
				<th>Week</th>
				<th>Sales($)</th>
			</tr>
			<%
				ArrayList<StoreSales> storeSales = (ArrayList<StoreSales>) request.getAttribute("storeSales");
				System.out.println(storeSales.size());
				for (StoreSales ss : storeSales) {
					//StoreSales ss = StoreSalesDB.getStoreSalesFromRow();
					//NumberFormat nf=NumberFormat.getInstance();
					System.out.println("StoreID: " + ss.getStoreID() + "Year: " + ss.getYear() + "Week :" + ss.getWeek()
							+ "Sales :" + "$" + ss.getSales());
			%>
			<tr>
				<td><%=ss.getStoreID()%></td>
				<td><%=ss.getYear()%></td>
				<td><%=ss.getWeek()%></td>
				<td><%=ss.getSales()%></td>

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