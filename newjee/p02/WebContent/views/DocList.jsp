<%@page import="java.util.Vector"%>
<%@page import="com.esisa.jee.models.Document"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des Documents</h1>
	


	
	<table border="1" style="border-collapse: collapse; width: 100%">


		<%
			Vector<Document> docs = (Vector<Document>) request.getAttribute("model");
			for (Document doc : docs) {
		%>
		
			<tr>
			<td><% doc.getIsbn(); %></td>
			<!-- Tag d'expression -->
			<td><%= doc.getTitle() %></td>
			<td><%= doc.getYearPublished() %></td>
			</tr>
		<%
			}
		%>
	</table>
</body>
</html>