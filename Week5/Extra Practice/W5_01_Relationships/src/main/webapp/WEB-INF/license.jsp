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
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">License Details</h1>
		<div class="card-body">
			<h3 class="card-text">Add a License</h3>
			<form:form action='/licenses' method = 'post' modelAttribute="license">
				<div class="form-group">
					<form:label path="number">License Number </form:label>
					<form:errors path= "number" class="text-danger"/>
					<form:input class="form-control" path= "number"/>
				</div>
				<div class="form-group">
		        	<form:label path="expirationDate">Expiration Date</form:label>
					<form:errors path= "expirationDate" class="text-danger"/>
			        <form:textarea  class="form-control" path="expirationDate"/>
				</div>
				<div class="form-group">
		        	<form:label path="state">State</form:label>
					<form:errors path= "state" class="text-danger"/>
			        <form:textarea  class="form-control" path="state"/>
				</div>
				
				<div class="form-group">
    				<form:select path="person">
						<c:forEach var="person" items="${allPersons}">
							<option value="${person.id}">
								<c:out value="${person.firstName}"/>
							</option>	
						</c:forEach>
					</form:select>
					
					
					
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</div>
	
</body>
</html>