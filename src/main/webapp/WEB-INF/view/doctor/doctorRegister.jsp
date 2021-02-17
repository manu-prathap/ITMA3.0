<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="save" modelAttribute = "doctor" method="POST" >
    <h1>Register</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="doctor_email" id="doctor_email" required>
	<br>
    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="password" id="password" required>
	<br>
    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="psw-repeat" id="psw-repeat" required>
    <br>
    <label for="fname"><b>First Name</b></label>
    <input type="text" placeholder="Enter First Name" name="first_name" id="first_name" required>
    <br>
    <label for="lname"><b>Last Name</b></label>
    <input type="text" placeholder="Enter Last Name" name="last_name" id="last_name" required>
    
  <input type="submit">
</form>
</body>
</html>