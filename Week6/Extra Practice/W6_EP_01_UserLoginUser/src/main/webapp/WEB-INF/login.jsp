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
<body class="card yt-5 pt-5 bg-dark">
	<div class="d-flex d-flex text-center align-self-center">
		<div class="p-4 bg-secondary text-white mx-10">
			<h1 class="card-header">Register</h1>
			<form:form action="/register" method="post" modelAttribute="newUser">
				<div class="form-group card-body">
					<form:label path="username">Username:</form:label>
					<form:errors path="username"/>
					<form:input class="form-control" path="username"/>
				</div>
				<div class="form-group card-body">
					<form:label path="email">Email:</form:label>
					<form:errors path="email"/>
					<form:input class="form-control" path="email"/>
				</div>
				<div class="form-group card-body">
					<form:label path="password">Password:</form:label>
					<form:errors path="password"/>
					<form:input type="password" class="form-control" path="password"/>
				</div>
				<div class="form-group card-body">
					<form:label path="confirm">Email:</form:label>
					<form:errors path="confirm"/>
					<form:input type="password" class="form-control" path="confirm"/>
				</div>
				<input class="btn btn-warning" type="submit" value="Submit"/>
			
			</form:form>
		</div>
		<div class="p-4 card bg-secondary text-white mx-5">
			<h1 class="card-header">Login</h1>
			<form:form action="/login" method="post" modelAttribute="newLogin">

				<div class="form-group card-body">
					<form:label path="email">Email:</form:label>
					<form:errors path="email"/>
					<form:input class="form-control" path="email"/>
				</div>
				<div class="form-group card-body">
					<form:label path="password">Password:</form:label>
					<form:errors path="password"/>
					<form:input type="password" class="form-control" path="password"/>
				</div>
				<input class="btn btn-primary" type="submit" value="Submit"/>
			
			</form:form>
		</div>




	</div>

</body>
</html>