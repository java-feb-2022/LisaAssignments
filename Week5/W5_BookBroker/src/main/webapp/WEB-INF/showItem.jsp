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
<body class="card bg-dark yt-5 pt-5 ">
	<div class="card bg-dark">
		<div class="card-header text-light text-center">
			<a class="btn btn-warning" href="/books">Back to the shelves</a>
			<h1>${showBook.title}</h1>
			<h5>
			
				<c:choose>
					<c:when test="${showBook.modifier.id == userLogin.id}">
						You
					</c:when>
					<c:otherwise>
						${showBook.modifier.name}
					</c:otherwise>	
				
				</c:choose>
				
			read ${showBook.title} by ${showBook.authorName}</h5>
			<h5>Here are 
				<c:choose>
					<c:when test="${showBook.modifier.id == userLogin.id}">
						your
					</c:when>
					<c:otherwise>
						${showBook.modifier.name}'s
					</c:otherwise>	
						
				</c:choose>
			thoughts</h5>
			<hr>
		</div>
		<div class="card-body bg-light mx-auto" style="width: 60rem">
			<hr>
			<p class="text-dark text-left">
				${showBook.thoughts}
			</p>
			<hr>
		</div>
		<hr>
	</div>
	<a class="btn btn-primary" href="/books/${showBook.id}/edits">Edit</a>
	
</body>
</html>