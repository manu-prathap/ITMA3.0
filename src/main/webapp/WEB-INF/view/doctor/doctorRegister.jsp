<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %>    
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
</head>
<body>
<div class = "container">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "doctor"  enctype="multipart/form-data" action = "save">
<form:label path="doctor_email">Email ID</form:label>
<form:input path="doctor_email" required = "true"/><br />
<form:label path="first_name">First Name:</form:label>
<form:input path="first_name" required = "true"/><br />
<form:label path="last_name">Last Name:</form:label>
<form:input path="last_name" required = "true"/><br />
<form:label path="phone_number" maxlength="12" >Phone number:</form:label>
<form:input type="number" path="phone_number" required = "true"/><br />
<form:label path="password">Enter a password</form:label>
<form:input path="password" type = "password" required = "true"/><br/>



<form:label path="address">address</form:label>
<form:input path="address" required = "true"/><br />
<form:label path="rate" maxlength="12" >rate</form:label>
<form:input type="number" path="rate" required = "true"/><br />

<form:label path="specialization">specialization</form:label>
<form:input path="specialization" required = "true"/><br />
<label for="id">Upload any ID Document</label>
<input type = "file" name = "file" accept = "image/jpeg, image/png, application/pdf"/><br />
<input type="submit" value = "Register" />

</form:form>
</div>

</form>
</body>
</html>