<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %>    
<!DOCTYPE html>
<html>

<head>
<c:set var="title" value="Set Schedule" />
<%@ include file = "../bootstrap.jspf" %>
<meta charset="UTF-8">
</head>
<body>

<form:form method = "POST" modelAttribute = "schedule" action = "submitschedule">

<div class = "row">

 <div class = "col-md-2">
 <form:label path = "dayOfWeek">Day:</form:label>
 </div>

 <div class = "col-md-10">
 <form:select path = "dayOfWeek">
 <c:forEach var = "day" items = "${ daysOfWeek }">
  <option value = "${ day }">${ day }</option>
 </c:forEach>
 </form:select>
 </div>


</div>


<div class = "row">

<div class = "col-md-2">
<label for = "sTime">Start Time</label>
</div>

<div class = "col-md-10">
<input type = "time" name = "sTime" id = "sTime" />
</div>


</div>


<div class = "row">
 <div class = "col-md-2">
 <label for = "eTime">End Time</label>
 </div>

 <div class = "col-md-10">
 <input type = "time" name = "eTime" id = "eTime" />
 </div>

</div>


<div class = "row">

 <div class = "col-md-2">
 <form:label path = "maxCapacity">Capacity</form:label>
 </div>

 <div class = "col-md-10">
 <form:select path = "maxCapacity">
 <c:forEach var = "capacity" begin = "1" end = "50">
  <option value = "${ capacity }">${ capacity }</option>
 </c:forEach>
 </form:select>
 </div> 
 
</div>


<div class = "row">

  <div class = "col-md-2">
 <form:label path = "consultationFee">Fee</form:label>
 </div>

 <div class = "col-md-10">
 <form:input type = "number" path = "consultationFee" />
 </div>
</div>

<div class = "row">
<input type = "submit" value = "Set Schedule" />
</div>

</form:form>

</body>
</html>