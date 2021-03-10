<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%> 
<%@ include file = "../formBase.jspf" %>   
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Prescription for ${ patient.firstName }" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="ISO-8859-1">
</head>

<body>
<h3>Prescribing for ${ patient.firstName } &nbsp; ${ patient.lastName } </h3>

<form:form method = "POST" modelAttribute = "prescription" action="issueDiag">

<form:input path="note" type = "textarea" /><br />

<input type = "hidden" name = "id" value = ${ patient.userId }>
<input type = "submit" value = "Issue"/>
</form:form>



</body>
</html>