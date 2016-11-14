<%@page import="entidades.Personaje"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Combate!!</title>
</head>
<body>
	<h1>Combate!!</h1>
	<% 
		Personaje p1= ((Personaje)session.getAttribute("P1"));
		Personaje p2= ((Personaje)session.getAttribute("P2"));
	%>
<%-- 	<%=p1.getNombre()+" "+p1.getApellido() %> --%>
<%-- 	<%=p2.getNombre()+" "+p2.getApellido() %> --%>
</body>
</html>