<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
=======
    <%@ include file = "../formBase.jspf" %>  
<!DOCTYPE html>
<html>
<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
>>>>>>> master
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class = "container">

<h2>Enter the details</h2>

<<<<<<< HEAD
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
=======
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

>>>>>>> master
</body>
</html>