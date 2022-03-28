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
<title>ShowItem</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="card yt-5 pt-5 bg-light">
	
	<div>
		<div class="m-3 d-flex justify-content-between card-heading text-center align-self-center">
			<h2>Welcome ${userLogin.name}</h2>
			
			<h2><a class="btn btn-danger" href="/logout">Logout</a></h2>
		</div>
		<div class="m-3 d-flex justify-content-between card-heading text-center align-self-center">
			<h4>All Projects</h4>
			
			<h4><a class="btn btn-warning" href="/dashboard">Back To Dashboard</a></h4>
		</div>
		<hr>
		<table class="table table-striped">
		
			<tr>
				<td>Project Name:<td>
				<td>${showProject.projectName}<td>
			</tr>
			<tr>
				<td>Project Description:<td>
				<td>${showProject.description}:<td>
			</tr>
			<tr>
				<td>Due Date:<td>
				<td><fmt:formatDate type="date" pattern="MM-dd-yyyy" value="${showProject.dueDate}"/><td>
			</tr>
					
		</table>

		<c:if test="${showProject.user.id==userLogin.id}">
			<div class="d-flex justify-content-end">
				<a class="btn btn-danger" href="/delete/project/${project.id}">Delete</a>
			</div>
		</c:if>
	</div>
		
</body>
</html>