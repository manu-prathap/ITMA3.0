<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Diagnostic History of ${ patient.firstName }" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="ISO-8859-1">
</head>

<body>
<div class = "row">
<table class = "table">
<c:if test="${ not empty diagnostics }">
<tr>
<th scope = "col">Date</th>
<th></th>
</tr>
<c:forEach var = "diagnostic" items=${ diagnostics }>
<tr>
<td>${ diagnostic.createTime }</td>
<td><a href = "viewDiagnosis?id=${ diagnostic.id }">View</a>
</tr>
</c:forEach>
</c:if>
</table>
</div>
<a href="createDiagnosis?id=${ patient.userId }">Prescribe New</a>
</body>
</html>