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
<body class="card yt-5 pt-5 bg-light">
	
	<div>
		<div class="card-heading text-center align-self-center">
			<h4>Welcome ${userLogin.name}</h4>
			
			<a class="btn btn-danger" href="/logout">Logout</a>
		</div>
		<div class="card-body">
			<hr>
			<h5 class="card-body">This is your dashboard. Nothing to see here yet.</h5>
		</div>
			<table class="table">
	
				<tr>
					<th>header</th>
					<th>header</th>
					<th>header</th>
					<th>header</th>
					<th>Actions</th>
				</tr>
				<tr>
					<c:forEach var="book" items="${allBooks}">
						<tr>
							<td><c:out value="${book.id}"/></td>
							<td>
								<a href="/books/${book.id}">
									<c:out value="${book.title}"/>
								</a>
							</td>
							<td><c:out value="${book.authorName}"/></td>
							<td><c:out value="${book.modifier.name}"/></td> 
							<td>
								<a class="btn btn-warning" href="/books/${book.id}/edits">Edit</a>	
								<c:if test="${book.modifier.id==userLogin.id}">
										<a class="btn btn-danger" href="/delete/book/${book.id}">Delete</a>
								</c:if>
								
							</td>
						</tr>
					</c:forEach>
				</tr>
				
			</table>
		
	</div>
		
</body>
</html>