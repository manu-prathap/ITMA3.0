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

<div class = "row">

<div class = "col-md-4">
<a href="#">Appointments<span class="badge">${ scheduleNumber }</span></a><br>
</div>

<div class = "col-md-4">
<a href="userdetails">View/Edit Details</a><br>
</div>

<div class = "col-md-4">
<a href="#">Diagnostics</a>
</div>



</div>
<!-- Search bar -->
<form method = "GET" action="search" class="search-bar">
<input type = "text" placeholder = "Search" name = "query"/><input type = "submit" value = "search"/>
</form>
<!-- Search bar end -->


<!-- Search panel start -->
<c:if test = "${not empty doctors}">

<table class = "table">
<tr>
<th scope = "col">
Name
</th>
<th scope = "col">
Location
</th>
<th scope = "col">
Specialization
</th>
<th scope = "col">
</th>
<th scope = "col">
</th>
</tr>
<c:forEach var = "doctor" items="${ doctors }" >
<tr>
<td>${ doctor.firstName }</td>
<td>${ doctor.streetAddress } &nbsp;  ${ doctor.district }</td>
<td><c:forEach var = "doctorspecialization" items = "${ doctor.specializations }">${ doctorspecialization.specialization }<br /></c:forEach></td>
<td><a href="details?id=${ doctor.id }">View Details</a></td>
<td><a href="schedules?id=${ doctor.id }">View Schedules</a></td>
</tr>
<!-- Search panel end -->


</c:forEach>
</table>
</c:if>




</body>
</html>