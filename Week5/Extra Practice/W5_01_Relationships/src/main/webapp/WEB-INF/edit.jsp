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
<title>Edit Person</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="d-flex mx-5" >
		<form class="mx-2" action="/persons/delete/${editPerson.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input type="submit" value="Delete" class="btn btn-danger">
		</form>
		<a class="btn btn-primary" href="/">Dashboard</a>
	</div>
	<h1>Edit this person: <c:out value="${editPerson.firstName}"/></h1>

	<form:form action="/persons/${editPerson.id}" method="post" modelAttribute="editPerson">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="firstName">FirstName</form:label>
        <form:errors path="firstName" class="text-danger"/>
        <form:input class="form-control" path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Creator</form:label>
        <form:errors path="lastName" class="text-danger"/>
        <form:textarea class="form-control" path="lastName"/>
    </p>   
    <input type="submit" value="Submit"/>
</form:form>
	
	

</body>
</html>