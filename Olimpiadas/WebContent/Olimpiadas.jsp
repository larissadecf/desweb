<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="model.Olimpiadas" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Olimpiadas</title>
</head>
<body>
<%Olimpiadas olimpiadas = (Olimpiadas)request.getAttribute("olimpiadas"); %>
Ano: <%=olimpiadas.getAno() %><br>
Tipo: <%=olimpiadas.getTipo() %><br>
Pais: <%=olimpiadas.getPais() %><br>
Modalidades: <%=olimpiadas.getModalidade() %><br>
</body>
</html>