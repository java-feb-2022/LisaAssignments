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
<title>Show Person</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<table class="table">
    <thead class="thead-dark">
        <tr>
            <th>Name</th>
            <th>License Number</th>
            <th>State</th>
            <th>Exp Date</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>
                <c:out value="${person.firstName}"/>
                <c:out value="${person.lastName}"/>
            </td>
            <td><c:out value="${person.license.state}"/></td>
            <td><c:out value="${person}"/></td>
            <td>
                <c:out value="${person.license.expirationDate}"/>
            </td>
        </tr>
    </tbody>
</table>
	
	<div class="card container">
		<div class="d-flex justify-content-end">
			<a href="/persons" class="btn btn-primary">Go Home</a>
		</div>
		<h1 class="card-header"><c:out value="${showPerson.firstName}"/></h1>
		<div class="card-body">
			<h4><c:out value="${showPerson.firstName}"/></h4>
			<h4><c:out value="${showPerson.lastName}"/></h4>
			<div class="d-flex mx-5" >
				<form class="mx-2" action="/persons/delete/${showPerson.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete" class="btn btn-danger">
				</form>
				<a href="/persons/edit/${showPerson.id}" class="btn btn-info">Dashboard</a>
			</div>
		</div>
	</div>
</body>
</html>