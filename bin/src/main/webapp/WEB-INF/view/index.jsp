<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="ITMA" />
<%@ include file="bootstrap.jspf" %>
<meta charset="UTF-8">
<title>Integrated TeleMedicine Application</title>
</head>
<body>
<div class = "container">
<div class = "row">
<div class = "jumbotron">
<h2>Integrated Telemedicine Application</h2>
</div>
</div>
<div class = "col-md-4">

<a href="user/register" style="font-size:60px">Registration</a><br />
<a href="user/login" style="font-size:60px">Login</a>

</div>
</div>
</body>
</html>