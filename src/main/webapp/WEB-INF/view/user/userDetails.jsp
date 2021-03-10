<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<c:set var="title" value="Welcome ${name}" />
<%@ include file = "../bootstrap.jspf" %>

<script>

function enableEdit(){
	
	let el = document.getElementsByClassName("edit");
	
	for(var i=0; i<el.length; i++)
		 el[i].removeAttribute("readonly");

	document.getElementById("submit").removeAttribute("disabled");
	
	
}


</script>

</head>

<body>
<div class = "row">
<h5>Physical Details:</h5><br />
</div>

<div class = "form-group">
<form method = "POST" action="detailsUpdate">
<div class = "row">

<label for="height" class = "col-md-2">
Height:
</label>
<div class = "col-md-10">
<input type = "text" value = "${ details.height }" name="height" id = "height" class = "edit" readonly ><br />
</div>
</div>

<div class = "row">
<label for="weight" class = "col-md-2">
Weight:
</label>
<div class = "col-md-10">
<input type = "text" value = "${ details.weight }" name="weight" id = "weight" class = "edit" readonly ><br />
</div>
</div>

<div class = "row">
<label for="bloodgroup" class = "col-md-2">
Blood Group:
</label>
<div class = "col-md-10">
<input type = "text" value = "${ details.bloodGroup }" name="bloodgroup" id = "bloodgroup" class = "edit" readonly ><br />
</div>
</div>



<div class = "row">
<label for="profession" class = "col-md-2">
Profession:
</label>
<div class = "col-md-10">
<input type = "text" value = "${ details.profession }" name="profession" id = "profession" class = "edit" readonly ><br />
</div>
</div>





<div class = "row">
<div class = "col-md-2">
BMI:
</div>
<div class = "col-md-10">
<p>${ bmi }</p>
<small>Calculated on the basis of height and weight inputs.</small>
</div>
</div>


<div class = "row">
<div class = "col-md-6">
<input type = "submit" value = "Submit" id="submit" disabled>
</div>

<div class = "col-md-6">
<button type = "button" onclick = "enableEdit()" >Edit</button> <!-- Set button type to "button" as its submit by default -->
</div>
</div>
</form>
</div> <!-- End of form-group -->

</body>
</html>