<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class = "container">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "adminForm" enctype="multipart/form-data">
<form:label path="email">email ID</form:label>
<form:input path="email" required/><br />
<form:label path="firstName">First Name:</form:label>
<form:input path="firstName" required/><br />
<form:label path="lastName">Last Name:</form:label>
<form:input path="lastName" required/><br />
<form:label path="phoneNo" maxlength="12" >Phone number:</form:label>
<form:input type="number" path="phoneNo" required/><br />
<form:input path="adminId" required/></form:label> 
<input type="submit" value = "Register" />
</form:form>
</div>
</body>
</html>