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
<title>Show Language</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
		<div class="d-flex justify-content-end">
			<a href="/languages" class="btn btn-primary">Go Home</a>
		</div>
		<h1 class="card-header"><c:out value="${showLanguage.name}"/></h1>
		<div class="card-body">
			<h4><c:out value="${showLanguage.creator}"/></h4>
			<h4><c:out value="${showLanguage.version}"/></h4>
			<div class="d-flex mx-5" >
				<form class="mx-2" action="/languages/delete/${showLanguage.id}" method="post">
				    <input type="hidden" name="_method" value="delete">
				    <input type="submit" value="Delete" class="btn btn-danger">
				</form>
				<a href="/languages/edit/${showLanguage.id}" class="btn btn-info">Dashboard</a>
			</div>
		</div>
	</div>
</body>
</html>