<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Welcome ${name}" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="UTF-8">
<title>Upcoming Appointments</title>
</head>
<body>
<h3>Upcoming Appointments:</h3>

<table class="table">
<tr>
<th>Patient Name</th>
<th>Email</th>
<th>Phone No</th>
<th>Basic Details</th>
<th>Diagnostic History</th>
</tr>
  
<c:forEach var = "appointment" items = "${ appointments }" >  
  
<c:if test = "${ appointment.schedule.dayOfWeek == 'Monday'  }" >
<tr>
<th scope = "row">Monday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="viewdetails?id=${ appointment.user.userId }">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>  
</c:if> 


<c:if test = "${ appointment.schedule.dayOfWeek == 'Tuesday'  }" >
<tr>
<th scope = "row">Tuesday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>  
</c:if> 



<c:if test = "${ appointment.schedule.dayOfWeek == 'Wednesday'  }" >
<tr>
<th scope = "row">Wednesday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>  
</c:if> 


<c:if test = "${ appointment.schedule.dayOfWeek == 'Thursday'  }" >
<tr>
<th scope = "row">Thursday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>    
</c:if>


<c:if test = "${ appointment.schedule.dayOfWeek == 'Friday'  }" >
<tr>
<th scope = "row">Friday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>    
</c:if>


<c:if test = "${ appointment.schedule.dayOfWeek == 'Saturday'  }" >
<tr>
<th scope = "row">Saturday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>  
</c:if>

<c:if test =" ${ appointment.schedule.dayOfWeek == 'Sunday'  }" >
<tr>
<th scope = "row">Sunday</th>
</tr>  
<tr>
<td>${ appointment.user.firstName }</td>
<td>${ appointment.user.email }</td>
<td>${ appointment.user.phoneNo }</td>
<td><a href="#">Details</a></td>
<td><a href="#">Diagnostic History</a></td>
</tr>    
</c:if>

</c:forEach>
 
</table>





</body>
</html>