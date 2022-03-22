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
			<h2>Welcome ${userLogin.name}</h2>
			<h5>Books from everyone's shelves</h5>
			<a class="btn btn-primary" href="/books/new">+Add to my shelf</a>
			<a class="btn btn-danger" href="/logout">Logout</a>
		</div>
		<div class="card-body">
			<hr>
			<table class="table">
			
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Actions</th>
			</tr>
			<tr>
				
				<c:forEach var="book" items="${allBooks}">
					<c:if test="${book.borrower.id==null}">
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
								<c:choose>
									<c:when test="${book.modifier.id==userLogin.id}">
										<a class="btn btn-info" href="/books/${book.id}/edits">Edit</a> |
										<a class="btn btn-danger" href="/delete/book/${book.id}">Delete</a>	
									</c:when>
									<c:otherwise>
										<a class="btn btn-warning" href="/borrow/${book.id}">Borrow</a>
									</c:otherwise>
								</c:choose>				
							</td>
						</tr>
					</c:if>
				</c:forEach>
				
			</tr>
			
			</table>
			
			
			
			
			
			<h3>Books I'm borrowing...</h3>	
			<table class="table">
			
			<tr>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
				<th>Actions</th>
			</tr>
			<tr>
				
				<c:forEach var="book" items="${allBooks}">
					<c:if test="${book.borrower.id!=null}">
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
								<c:choose>
									<c:when test="${book.modifier.id==userLogin.id}">
										<a class="btn btn-info" href="/books/${book.id}/edits">Edit</a> |
										<a class="btn btn-danger" href="/delete/book/${book.id}">Delete</a>	
									</c:when>
									<c:otherwise>
										<a class="btn btn-warning" href="/unborrow/${book.id}">Return</a>
									</c:otherwise>
								</c:choose>				
							</td>
						</tr>
					</c:if>
				</c:forEach>
				
			</tr>
			
			</table>
		</div>
		
	</div>
		
</body>
</html>