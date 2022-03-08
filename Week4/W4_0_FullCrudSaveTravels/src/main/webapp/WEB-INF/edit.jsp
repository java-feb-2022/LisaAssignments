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
<title>Edit Expense</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Edit this expense: <c:out value="${editExpense.expDescription}"/></h1>

	<form:form action="/expenses/${editExpense.id}" method="post" modelAttribute="editExpense">
    <input type="hidden" name="_method" value="put">
    <p>
        <form:label path="expDescription">Title</form:label>
        <form:errors path="expDescription" class="text-danger"/>
        <form:input class="form-control" path="expDescription"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor" class="text-danger"/>
        <form:textarea class="form-control" path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Pages</form:label>
        <form:errors path="amount" class="text-danger"/>     
        <form:input class="form-control" type="number" path="amount"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>
	
	

</body>
</html>