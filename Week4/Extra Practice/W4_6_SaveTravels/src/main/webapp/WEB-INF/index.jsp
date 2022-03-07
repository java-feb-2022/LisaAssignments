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
	<expDescription>Expenses</expDescription>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Expenses Page</h1>
		<a href="/expenses/new">Create new expense</a>
		<div class="card-body">
			<table class="table table-striped table-bordered">
		        <tr>
		        	<th>Title</th>
		        	<th>Vendor:</th>
		        	<th>Language</th>
		        	<th>Page Count</th>
		        	<th>Actions</th>
		        </tr>
			    <c:forEach var="expense" items="${allExpenses}">
			        <tr>
						<th><a href="/expenses/${expense.id}"><c:out value="${expense.expDescription}"/></a></th>
						<td><c:out value="${expense.vendor}"/></td>
						<td><c:out value="${expense.amount}"/></td>
						<td>
							<a href="/expenses/${expense.id}/edit" type="button">Edit</a>
						</td>
		        	</tr>
			    </c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>