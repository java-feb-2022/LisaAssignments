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
<title>Login and Register</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="js/app.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body class="bg-dark">
	<div class="p-4 card bg-dark text-white mx-5">
		<h1 class="text-center card-header m-3 p-4">New Category</h1>
	<form:form action="/projects/${editProject.id}/edit" class="text-center container" modelAttribute="editProject">
		
      <!-- userId -->
	  	<form:input type="hidden" value="${userLogin.id}" path="user"/>    

		<div class="form-group card-body">
			<form:label path="projectName">Project Name:</form:label>
			<form:errors path="projectName" class="text-danger" />
			<form:input class="form-control" path="projectName"/>
		</div>
		<div class="form-group card-body">
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger" />
			<form:input class="form-control" path="description"/>
		</div>
		<div class="form-group card-body">
			<form:label path="dueDate">DueDate:</form:label>
			<form:errors path="dueDate"/>
			<form:input type="date" class="form-control" path="dueDate"/>
		</div>
		<a class="btn btn-warning" href="/dashboard">Cancel</a>			
		<input class="btn btn-info" type="submit" value="Submit"/>
	</form:form>
		</div>
</body>
</html>