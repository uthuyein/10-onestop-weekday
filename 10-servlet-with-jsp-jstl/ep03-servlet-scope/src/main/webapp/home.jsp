<%@page import="com.jdc.mkt.model.Counter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scope Test</title>
</head>
<body>
	<a href="scope"> <h1>Scope Servlet</h1></a>
	<ul>
		<li>
			<% var c1 = (Counter)request.getAttribute("COUNTER"); 
				if(null != c1){
			%>
			<h3>REQUEST COUNTER  VALUE : <%= c1.getCount() %></h3>
			 <%} %>			
		 </li>
		<li>
			<% var c2 = (Counter)session.getAttribute("COUNTER"); 
			if(null != c2){
			%>
		<h3>SESSION COUNTER  VALUE : <%= c2.getCount() %></h3>
		 <%} %>		
		</li>
		<li>
			<% var c3 = (Counter)application.getAttribute("COUNTER"); 
				if(null != c3){
			%>
			<h3>APPLICATION COUNTER  VALUE : <%= c3.getCount() %></h3>
			 <%}%>
			
		</li>
	</ul>
</body>
</html>