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
	<div class="card-header text-light text-center">
		<h1>Book Club</h1>
		<h5>A place for friends to share thoughts on books</h5>
		<a class="btn btn-warning" href="/books">Back to the shelves</a>
		<hr>
	</div>
	<div class="d-flex d-flex text-center align-self-center">
		<div class="p-4 bg-secondary text-white mx-10">
			<h1 class="card-header">Edit</h1>
			<c:choose>
				<c:when test="${editBook.modifier.id==userLogin.id}">
					<form:form action="/books/${editBook.id}/edit" method="POST" modelAttribute="editBook">
						<form:input type="hidden" value="${editBook.modifier.id}" path="modifier" />
						<div class="form-group card-body">
							<form:label path="title">Title:</form:label>
							<form:errors path="title"/>
							<form:input class="form-control" path="title"/>
						</div>
						<div class="form-group card-body">
							<form:label path="authorName">Author Name:</form:label>
							<form:errors path="authorName"/>
							<form:input class="form-control" path="authorName"/>
						</div>
						<div class="form-group card-body">
							<form:label path="thoughts">Thoughts:</form:label>
							<form:errors path="thoughts"/>
							<form:textarea class="form-control" path="thoughts"/>
						</div>
						
						<input class="btn btn-primary" type="submit" value="Submit"/>
					</form:form>
				</c:when>
				<c:otherwise>
					<h3 class="card-body">You are not allowed to edit this item!</h3>
				</c:otherwise>
			</c:choose>
		</div>
	</div>

</body>
</html>