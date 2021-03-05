<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="title" value="Welcome ${name}" />
<%@ include file = "../bootstrap.jspf" %>
</head>
<body>
<h3>Welcome ${name}</h3>
<h4 style = "text-align: center">Doctor details are: </h4><br />

<div class = "row">
<p style = "text-align: center">Dr ${ doctor.firstName } ${ doctor.lastName }</p><br />
</div>
<div class = "row">
<h5 style = "text-align: center">Specializations</h5><br/>
<p style = "text-align: center">
<c:forEach var = "doctorspecialization" items = "${ doctor.specializations }">${ doctorspecialization.specialization }<br /></c:forEach>
</p>
</div>

<div class = "row">

<h5 style = "text-align: center">Address</h5><br/>

<p style = "text-align: center">
${ doctor.streetAddress }<br />
${ doctor.district }<br />
${ doctor.state }<br />
${ doctor.country }<br />
${ doctor.pinCode }<br />
</p>

</div>
<div class = "row">

<a href="book?id=${ doctor.id }" style = "text-align: center">View Schedules and Book</a>

</div>

</body>
</html>