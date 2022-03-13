<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="java.util.Date" %>

<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>

<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"  %>
    
<!-- Formatting (dates) --> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dashboard</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script type="text/javascript" src="js/app.js"></script>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<a href="dojos">Dashboard</a>
		<a href="/ninjas">Register a new Ninja</a>
		<h1> New Dojo </h1>
		
		<form:form class="form" action="/dojos" method="post" modelAttribute="dojo">
		
			<div class="form-group row">
				<form:errors path="location" class="errors"></form:errors>
				<form:label path="location">Location:</form:label>
				<form:input type="text" path="location"/>
			</div>
			<input type="submit" class="btn btn-primary" value="Create"/>
		
		</form:form>
		
		<table class="table">
		
			<tr class="table-info">
				<th>Location</th>
				<th>Action</th>
			</tr>
		
		</table>
		
	</div>
</body>
</html>