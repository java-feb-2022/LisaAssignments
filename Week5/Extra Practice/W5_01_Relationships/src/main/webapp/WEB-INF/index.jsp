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
	<title>Persons</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script type="text/javascript" src="js/app.js"></script>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Person Details</h1>
		<div class="card-body">
			<table class="table table-striped table-bordered">
		        <tr>
		        	<th> Name </th>
		        	<th> License Number </th>
		        	<th> State </th>
		        	<th> Exp Date </th>
		        	<th> Actions </th>
		        </tr>
			    <c:forEach var="person" items="${allPersons}">
			        <tr>
						<th>
							<a href="/persons/${person.id}">
								<c:out value="${person.firstName}"/>
								<c:out value="${person.lastName}"/>
							</a>
						</th>
						<td><c:out value="${person.license.state}"/></td>
						<td><c:out value="${person.license.expirationDate}"/></td>
						<td class="d-flex">
							<a href="/persons/edit/${person.id}" type="button" class="mx-2 btn btn-primary">Edit</a>
							<form class="mx-2" action="/persons/delete/${person.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
		        	</tr>
			    </c:forEach>
			</table>
			<h3 class="card-text">Add an person</h3>
			<form:form action='/persons' method = 'post' modelAttribute="person">
				<div class="form-group">
					<form:label path="firstName">First Name </form:label>
					<form:errors path= "firstName" class="text-danger"/>
					<form:input class="form-control" path= "firstName"/>
				</div>
				<div class="form-group">
		        	<form:label path="lastName">Last Name</form:label>
					<form:errors path= "lastName" class="text-danger"/>
			        <form:textarea  class="form-control" path="lastName"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</div>
	
</body>
</html>