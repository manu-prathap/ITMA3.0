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

<form:label path="phone_number">Phone number:</form:label>
<form:input type="tel" path="phone_number" required = "true"/><br />

<form:label path="dob">Dob</form:label>
<form:input path="dob" type="date" required = "true"/><br />

<form:label path="password">Enter a password</form:label>
<form:input path="password" type = "password" required = "true"/><br/>

<form:label path="address">Address</form:label>
<form:input path="address" type="textarea" required = "true"/><br />

<form:label path="district">District</form:label>
<form:input path="district" required = "true"/><br />

<form:label path="state">State</form:label>
<form:input path="state" required = "true"/><br/>

<form:label path="country">Country</form:label>
<form:input path="country" required = "true"/><br />

<form:label path="pincode" maxlength="12" >Pincode</form:label>
<form:input type="text" path="pincode" pattern="^[0-9]{6}$" required = "true"/><br />

<label for="specialization">specialization</label>
<input type="specialization" name = "specialization" required = "true"/><br />

<label for="id">Upload any ID Document</label>
<input type = "file" name = "file" accept = "image/jpeg, image/png, application/pdf"/><br />
<input type="submit" value = "Register" />

</form:form>
</div>

</form>
</body>
</html>