<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %>    
<!DOCTYPE html>
<html>

<head>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="UTF-8">
</head>
<body>
<div class = "container" ng-controller="formControl">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "userForm" enctype="multipart/form-data" action = "submit">

<div class = "row">
<div class = "form-group" >
<div class = "col-md-6">
<form:label path="email">email ID</form:label><br/>
<form:input path="email" required = "true"/><br />
</div>
<div class = "col-md-6">
<form:label path="phoneNo" maxlength="12">Phone number:</form:label><br/>
<form:input type="number" path="phoneNo" required = "true"/><br />
</div>
</div>
</div>
<br/>

<div class = "row">
<div class = "form-group">
<div class = "col-md-6">
<form:label path="firstName">First Name:</form:label><br/>
<form:input path="firstName" required = "true"/><br />
</div>
<div class = "col-md-6">
<form:label path="lastName">Last Name:</form:label><br/>
<form:input path="lastName" required = "true"/><br />
</div>

</div>
</div>



<div class = "form-group">

<form:label path="dob">Dob</form:label>
<form:input path="dob" type="date" required = "true" min = "1921-01-01" max = "2003-01-01"/><br />

</div>

<div class = "form-group">
<form:label path="gender">Gender</form:label><br/>
<form:select path = "gender">
<form:option value="Female">Female</form:option>
<form:option value="Male">Male</form:option>
<form:option value = "Not Specified">Not Specifying</form:option>
</form:select>

</div>

<div class = "form-group">
<form:label path="houseName" maxlength="12" >Enter Address:</form:label><br />
<form:input path="houseName" placeholder = "House or Flat Name/No." required = "true"/><br />
<form:input path="locationStreet" placeholder = "Location/Street Name" required = "true"/><br />
<form:input path="district" placeholder = "District" required = "true"/><br />
<form:input path="state" placeholder = "State" required = "true"/><br />
<form:input path="country" placeholder = "Country" required = "true"/><br />
<form:input path="pinCode" placeholder = "PIN Code" required = "true"/><br />
</div>

<div class = "form-group">
<label for="id">Upload any ID Document</label>
<input type = "file" name = "id" accept = "image/jpeg, image/png, application/pdf" class="btn btn-info"><br />
</div>
<div class = "form-group">
<form:label path="">Enter password</form:label><p id="pwd_valid"></p><br/>
<form:input path="" type = "password" required = "true" id = "pwd1"/><br/>
</div>
<div class = "form-group">
<form:label path="password">Confirm password</form:label><p id = "pwd_notmatch"></p><br/>
<form:input path="password" type = "password" required = "true" id = "pwd2"/><br/>
</div>
<input type="submit" value = "Register" class="btn btn-primary" />

</form:form>
</div>

</body>
</html>