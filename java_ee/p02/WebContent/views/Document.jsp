<%@page import="java.util.List"%>
<%@page import="com.esisa.jee.models.Document"%>
<%@page import="java.util.Vector"%><!--  tag de derective -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des docs</h1>
	<h1>${message }</h1>
	<!-- scplet -->
	<table border="1" style="border-collapse: collapse; width: 100%;">
	<%
			Vector<Document> docs = (Vector<Document>) request.getAttribute("docs");
			for (Document doc : docs) {
		%>
		
			<tr>
			<td><%= doc.getIsbn() %></td>
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