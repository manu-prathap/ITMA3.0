<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
   <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
=======
>>>>>>> master
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/w3.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/font-awesome.min.css" />" rel="stylesheet">
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"></c:url>"></script>

</head>
<body>
<<<<<<< HEAD

	<nav>
		<ul class="w3-navbar w3-card-4 w3-light-grey w3-left-align w3-top">
			<li class="w3-hide-medium w3-hide-large w3-black w3-opennav w3-right">
				<a href="javascript:void(0);" onclick="myFunction()"><i
					class="fa fa-caret-square-o-down" aria-hidden="true"></i></a></li>
			<li><a class="w3-cyan " href="#"><i class="fa fa-home"></i>
					HOME </a></li>
			<li class="w3-hide-small"><a href="${contextPath}/admin/userLog"
				style="display: inline-block"><i class="fa fa-list"
					aria-hidden="true"></i> User</a></li>
			<li class="w3-hide-small"><a href="${contextPath}/admin/doctorLog"
				style="display: inline-block"><i class="fa fa-list"
					aria-hidden="true"></i> Doctor</a></li>
			<li class="w3-hide-small" style="float: right"><a href="#"><i
					class="fa fa-sign-out"></i> Sign Out</a></li>	
	
		</div>
	</nav>
	<div style="margin-top:48px">
		<c:choose>
			<c:when test="${HomePageClicked}">
				<c:import url="/WEB-INF/view/user/homepage.jsp"></c:import>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${UserPageClicked}">
				<c:import url="/WEB-INF/jsp/userHome.jsp"></c:import>
			</c:when>
		</c:choose>
		<c:choose>
			<c:when test="${DoctorPageClicked}">
				<c:import url="/WEB-INF/jsp/doctorHome.jsp"></c:import>
			</c:when>
		</c:choose>
	</div>
=======
added admin!
>>>>>>> master
</body>
</html>