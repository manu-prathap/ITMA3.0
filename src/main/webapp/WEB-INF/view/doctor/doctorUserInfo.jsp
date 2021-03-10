<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Details of ${ patient.firstName }" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="ISO-8859-1">
</head>

<body>
<h3>Details of ${ patient.firstName } </h3>

<div class = "row">

<div class = "col-md-2">
Full Name:
</div>

<div class = "col-md-10">
${ patient.firstName } &nbsp; ${ patient.lastName }
</div>

</div>

<div class = "row">

<div class = "col-md-2">Blood Group</div>
<div class = "col-md-10">${ information.bloodGroup }</div>


</div>


<div class = "row">

<div class = "col-md-2">Height</div>
<div class = "col-md-10">${ information.height }</div>


</div>


<div class = "row">

<div class = "col-md-2">Weight</div>
<div class = "col-md-10">${ information.weight }</div>


</div>

<div class = "row">

<div class = "col-md-2">BMI</div>
<div class = "col-md-10">${ bmi }</div>


</div>




<div class = "row">

<div class = "col-md-2">Profession</div>
<div class = "col-md-10">${ information.profession }</div>


</div>


<div class = "row">

<div class = "col-md-2">Age(in years)</div>
<div class = "col-md-10">${ age }</div>


</div>

<div class = "row">
<a href="#" style = "allign:center">Edit Details</a>
</div>

</body>
</html>