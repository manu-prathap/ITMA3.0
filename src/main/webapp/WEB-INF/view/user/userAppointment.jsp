<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="title" value="View Appointments" />
<%@ include file = "../bootstrap.jspf" %>
</head>

<body>

  <table class = "table">
  <tr>
   <th scope = "col">
    Date
   </th>
   <th scope = "col">
    Day
   </th>
   <th scope = "col">
    Start Time
   </th>
   <th scope = "col">
    Status
   </th>
  </tr>
  
  <c:forEach var = appointment items = ${ appointments }>
  <tr>
    <td>
    
    </td>
    
    <td></td>
    
    <td></td>
    
    <td></td>  
  </tr>
  </c:forEach>
  
 
  
  </table>





</body>
</html>