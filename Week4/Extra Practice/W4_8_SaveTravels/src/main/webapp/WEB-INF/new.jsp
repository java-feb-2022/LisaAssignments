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
<title>New Expense</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Create a New Expense</h2>
	<form:form action='/expenses' method = 'post' modelAttribute="expense">
		<div>
			<form:label path= "expDescription">Expense:</form:label>
			<form:errors path= "expDescription" class="text-danger"/>
			<form:input path= "expDescription"/>
		</div>
		<div>
	        <form:label path="vendor">Vendor</form:label>
			<form:errors path= "vendor" class="text-danger"/>
	        <form:textarea path="vendor"/>
		</div>
		<div>
	        <form:label path="amount">Amount</form:label>
	        <form:errors path="amount" class="text-danger"/>     
	        <form:input type="number" path="amount"/>
		</div>
		<input type="submit" value="Submit"/>
	</form:form>
	<hr>
	<h5><a href="/expenses">Go Home</a></h5>

</body>
</html>