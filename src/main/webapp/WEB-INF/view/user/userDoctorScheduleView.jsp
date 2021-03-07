<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<c:set var="title" value="Welcome ${name}" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="ISO-8859-1">
</head>

<body>

<table>
<tr>
<th scope = "col">Day</th>
<th scope = "col">From</th>
<th scope = "col">To</th>
<th scope = "col">Fee</th>
<th scope = "col">Status</th>
<th></th>
</tr>
 <c:forEach var = "schedule" items = "${ schedules }">
   
    <c:if test ="${ schedule.dayOfWeek == 'Monday' }">
       <tr>
       <td scope = "row">
        Monday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>
   

   <c:if test ="${ schedule.dayOfWeek == 'Tuesday' }">
       <tr>
       <td scope = "row">
        Tuesday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>


    <c:if test ="${ schedule.dayOfWeek == 'Wednesday' }">
       <tr>
       <td scope = "row">
        Wednesday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>
   
       <c:if test ="${ schedule.dayOfWeek == 'Thursday' }">
       <tr>
       <td scope = "row">
        Thursday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>
   
     <c:if test ="${ schedule.dayOfWeek == 'Friday' }">
       <tr>
       <td scope = "row">
        Friday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>  
   
       <c:if test ="${ schedule.dayOfWeek == 'Saturday' }">
       <tr>
       <td scope = "row">
        Saturday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>
   
       <c:if test ="${ schedule.dayOfWeek == 'Sunday' }">
       <tr>
       <td scope = "row">
        Sunday
       </td>
       <td>
        ${ schedule.startTime }
       </td>
       <td>
        ${ schedule.endTime }
       </td>
       <td>
       ${ schedule.consultationFee }
       </td>
       <td>
       ${ schedule.isAvailable }
       </td>
       
       
     </tr>
   </c:if>
   
   
 </c:forEach>
</table>




</body>
</html>