<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Welcome ${name}" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="ISO-8859-1">
</head>
<body>
<h3>Welcome ${name}</h3>
<a href="#">Appointments<span class="badge">${ scheduleNumber }</span></a><br>
<form method = "GET" action="login/search" name = "query" class="search-bar">
<input type = "text" placeholder = "Search"/><input type = "submit" value = "search"/>
</form>

<c:if test = "${not empty doctors}">
<c:forEach var = "doctor" items="${ doctors }" >
<table>
<tr>
<th>
Name
</th>
<th>
Location
</th>
</tr>
<tr>
<td>${ doctor.firstName }</td>
<td>${ doctor.streetAddress }  ${ doctor.district }</td>
</tr>

</table>

</c:forEach>

</c:if>




</body>
</html>