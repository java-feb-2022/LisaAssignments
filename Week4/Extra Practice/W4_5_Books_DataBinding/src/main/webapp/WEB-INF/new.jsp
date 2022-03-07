<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="java.util.Date" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ page isErrorPage="true"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Book</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Create a New Book</h2>
	<form:form action='/books' method = 'post' modelAttribute="book">
		<div>
			<form:label path= "title">Title:</form:label>
			<form:errors path= "title" class="text-danger"/>
			<form:input path= "title"/>
		</div>
		<div>
	        <form:label path="description">Description</form:label>
			<form:errors path= "description" class="text-danger"/>
	        <form:textarea path="description"/>
		</div>
		<div>
	        <form:label path="language">Language</form:label>
	        <form:errors path="language" class="text-danger"/>
	        <form:input path="language"/>
		</div>
		<div>
	        <form:label path="numberOfPages">Pages</form:label>
	        <form:errors path="numberOfPages" class="text-danger"/>     
	        <form:input type="number" path="numberOfPages"/>
		</div>
		<input type="submit" value="Submit"/>
	</form:form>
	<hr>
	<h5><a href="/books">Go Home</a></h5>

</body>
</html>