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
<form:label path="doctorEmail">Email ID</form:label>
<form:input path="doctorEmail" required = "true"/><br />

<form:label path="firstName">First Name:</form:label>
<form:input path="firstName" required = "true"/><br />

<form:label path="lastName">Last Name:</form:label>
<form:input path="lastName" required = "true"/><br />

<form:label path="phoneNumber" maxlength="12" >Phone number:</form:label>
<form:input type="tel" path="phoneNumber" required = "true"/><br />

<form:label path="password">Enter a password</form:label>
<form:input path="password" type = "password" required = "true"/><br/>

<form:label path="streetAddress">Address</form:label>
<form:input path="streetAddress" type="textarea" required = "true"/><br />

<form:label path="district">District</form:label>
<form:input path="district" required = "true"/><br />

<form:label path="state">State</form:label>
<form:input path="state" required = "true"/><br/>

<form:label path="country">Country</form:label>
<form:input path="country" required = "true"/><br />

<form:label path="pinCode" maxlength="12" >Pincode</form:label>
<form:input type="text" path="pinCode" pattern="^[0-9]{6}$" required = "true"/><br />

<label for="specialization">specialization</label>
<input type="text" name = "specialization" required/><br />

<label for="id">Upload any ID Document</label>
<input type = "file" name = "file" accept = "image/jpeg, image/png, application/pdf"/><br />
<input type="submit" value = "Register" />

</form:form>
</div>

</body>
</html>