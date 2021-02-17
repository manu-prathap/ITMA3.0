<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file = "../formBase.jspf" %>  
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class = "container">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "adminForm" enctype="multipart/form-data" action = "submit">
<form:label path="firstName">First Name:</form:label>
<form:input path="firstName" required = "true"/><br />
<form:label path="lastName">Last Name:</form:label>
<form:input path="lastName" required = "true"/><br />
<form:label path="password">Enter a password</form:label><br/>
<form:input path="password" type = "password" required = "true"/><br/>
<input type="submit" value = "Register" />

</form:form>
</div>

</body>
</html>