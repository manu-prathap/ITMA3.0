<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %>    
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<div class = "container">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "userForm" enctype="multipart/form-data" action = "submit">
<form:label path="email">email ID</form:label>
<form:input path="email" required = "true"/><br />
<form:label path="firstName">First Name:</form:label>
<form:input path="firstName" required = "true"/><br />
<form:label path="lastName">Last Name:</form:label>
<form:input path="lastName" required = "true"/><br />
<form:label path="phoneNo" maxlength="12" >Phone number:</form:label>
<form:input type="number" path="phoneNo" required = "true"/><br />
<form:label path="houseName" maxlength="12" >Enter Address:</form:label><br />
<form:input path="houseName" placeholder = "House or Flat Name/No." required = "true"/><br />
<form:input path="locationStreet" placeholder = "Location/Street Name" required = "true"/><br />
<form:input path="district" placeholder = "District" required = "true"/><br />
<form:input path="state" placeholder = "State" required = "true"/><br />
<form:input path="country" placeholder = "Country" required = "true"/><br />
<form:input path="pinCode" placeholder = "PIN Code" required = "true"/><br />
<label for="id">Upload any ID Document</label>
<input type = "file" name = "id" accept = "image/jpeg, image/png, application/pdf"/><br />
<form:label path="password">Enter a password</form:label><br/>
<form:input path="password" type = "password" required = "true"/><br/>
<input type="submit" value = "Register" />

</form:form>
</div>

</body>
</html>