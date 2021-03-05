<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %>    
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
</head>
<body>
<div class = "container" ng-controller="formControl">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "doctor"  enctype="multipart/form-data" action = "save">

<div class = "row">
<div class = "form-group">

<div class = "col-md-6">
<form:label path="doctorEmail">Email ID</form:label><br />
<form:input path="doctorEmail" required = "true"/><br />
</div>

<div class = "col-md-6">
<form:label path="phoneNumber" maxlength="12" >Phone number:</form:label><br />
<form:input type="tel" path="phoneNumber" required = "true"/><br />
</div>

</div>
</div>
<div class = "form-group">
<div class = "row">


<div class = "col-md-6">
<form:label path="firstName">First Name:</form:label><br />
<form:input path="firstName" required = "true"/><br />
</div>

<div class = "col-md-6">
<form:label path="lastName">Last Name:</form:label><br />
<form:input path="lastName" required = "true"/><br />
</div>


</div>


</div>

<div class = "row">
<div class = "form-group">
<form:label path = "streetAddress">Address</form:label><br />
<form:input path="streetAddress" type="textarea" required = "true" placeholder = "House No./Name, Street Name"/><br />

<form:input path="district" required = "true" placeholder = "District"/><br />

<form:input path="state" required = "true" placeholder = "State"/><br/>

<form:input path="country" required = "true" placeholder = "Country"/><br />

<form:input type="text" path="pinCode" pattern="^[0-9]{6}$" required = "true" placeholder = "PIN CODE"/><br />

</div>
</div>

<div class = "row">
<div class = "form-group">
<label for="specialization">specializations (add one for now)</label><br />
<input type="text" name = "specialization" required/><br />

<label for="id">Upload any ID Document</label>
<input type = "file" name = "file" accept = "image/jpeg, image/png, application/pdf"/><br />

<div class="row">

<div class = "col-md-6">
<form:label path="password">Enter password</form:label><br />
<form:input path="" type = "password" required = "true"/><br/>
</div>


<div class = "col-md-6">
<form:label path="password">Confirm password</form:label><br />
<form:input path="password" type = "password" required = "true"/><br/>
</div>

</div>
<br />
<input type="submit" value = "Register" class="btn btn-primary" />

</div>

</div>


</form:form>
</div>

</body>
</html>