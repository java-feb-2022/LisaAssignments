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
	<title>Languages</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Languages</h1>
		<div class="card-body">
			<table class="table table-striped table-bordered">
		        <tr>
		        	<th> Languages </th>
		        	<th> Creator </th>
		        	<th> Version </th>
		        	<th> Actions </th>
		        </tr>
			    <c:forEach var="language" items="${allLanguages}">
			        <tr>
						<th>
							<a href="/languages/${language.id}">
								<c:out value="${language.name}"/>
							</a>
						</th>
						<td><c:out value="${language.creator}"/></td>
						<td><c:out value="${language.version}"/></td>
						<td class="d-flex">
							<a href="/languages/edit/${language.id}" type="button" class="mx-2 btn btn-primary">Edit</a>
							<form class="mx-2" action="/languages/delete/${language.id}" method="post">
							    <input type="hidden" name="_method" value="delete">
							    <input type="submit" value="Delete" class="btn btn-danger">
							</form>
						</td>
		        	</tr>
			    </c:forEach>
			</table>
			<h3 class="card-text">Add an language</h3>
			<form:form action='/languages' method = 'post' modelAttribute="language">
				<div class="form-group">
					<form:label path="name">Name </form:label>
					<form:errors path= "name" class="text-danger"/>
					<form:input class="form-control" path= "name"/>
				</div>
				<div class="form-group">
		        	<form:label path="creator">Creator</form:label>
					<form:errors path= "creator" class="text-danger"/>
			        <form:textarea  class="form-control" path="creator"/>
				</div>
				<div class="form-group">
			        <form:label path="version">Version</form:label>
			        <form:errors path="version" class="text-danger"/>     
			        <form:input class="form-control" type="text" path="version"/>
				</div>
				<input type="submit" value="Submit"/>
			</form:form>
		</div>
		
	</div>
	
</body>
</html>