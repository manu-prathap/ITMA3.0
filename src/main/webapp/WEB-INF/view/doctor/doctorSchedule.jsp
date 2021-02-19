<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../formBase.jspf" %> 
<!DOCTYPE html PUBLIC “-//W3C//DTD XHTML 1.0 Transitional//EN”  “http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd” >

<html xmlns=“http://www.w3.org/1999/xhtml” >   

<c:set var="title" value="Registration" />
<%@ include file = "../bootstrap.jspf" %>
</head>
<body>
<div class = "container">

<h2>Enter the details</h2>

<form:form method = "POST" modelAttribute = "doctorSchedule"  action = "saveSchedule">

<label for="doctorEmail">Doctor Email</label>
<input type="text" value=" ${doctorEmail}" name = "doctorEmail"/><br />

<label for="day">Day:</label>
<input type="text" name = "day"required /><br />

<label for="startTime">Start time</label>
<input  type="time" name = "startTime" step="1" required /><br />

<label for="endTime">End time:</label>
<input  type="time" name = "endTime" step="1" required /><br />

<label for="consultationFee">Consultation Fee:</label>
<input type="number" name="consultationFee" required /><br />

<label for="isAvailable">Available:</label>
<label for="isAvailable">No</label>
<input type="radio" name = "isAvailable" /><br />
<label for="isAvailable">Yes</label>
<input type="radio" name = "isAvailable"  /><br />

<label for="maxCapacity">Maximum Capacity</label>
<input type="number"  name = "maxCapacity" required/><br /> 

<input type="submit" value = "Schedule" />

</form:form>
</div>

</form>
</body>
</html>