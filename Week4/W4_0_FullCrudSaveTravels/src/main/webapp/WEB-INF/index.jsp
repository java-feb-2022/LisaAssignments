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
	<title>Expenses</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Save Travels</h1>
		<div class="card-body">
			<table class="table table-striped table-bordered">
		        <tr>
		        	<th> Expenses </th>
		        	<th> Vendor </th>
		        	<th> Amount </th>
		        	<th> Actions </th>
		        </tr>
			    <c:forEach var="expense" items="${allExpenses}">
			        <tr>
						<th>
							<a href="/expenses/${expense.id}">
								<c:out value="${expense.expDescription}"/>
							</a>
						</th>
						<td><c:out value="${expense.vendor}"/></td>
						<td><c:out value="${expense.amount}"/></td>
						<td class="d-flex">
							<a href="/expenses/edit/${expense.id}" type="button" class="mx-2 btn btn-primary">Edit</a>
							<form class="mx-2" action="/expenses/delete/${expense.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
		        	</tr>
			    </c:forEach>
			</table>
			<h3 class="card-text">Add an expense</h3>
			<form:form action='/expenses' method = 'post' modelAttribute="expense">
				<div class="form-group">
					<form:label path="expDescription">Expense: </form:label>
					<form:errors path= "expDescription" class="text-danger"/>
					<form:input class="form-control" path= "expDescription"/>
				</div>
				<div class="form-group">
		        	<form:label path="vendor">Vendor</form:label>
					<form:errors path= "vendor" class="text-danger"/>
			        <form:textarea  class="form-control" path="vendor"/>
				</div>
				<div class="form-group">
			        <form:label path="amount">Amount</form:label>
			        <form:errors path="amount" class="text-danger"/>     
			        <form:input class="form-control" type="number" path="amount"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</div>
	
</body>
</html>