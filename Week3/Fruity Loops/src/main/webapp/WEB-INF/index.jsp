<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8" import="java.util.Date" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
    <%@ page isErrorPage="true"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Fruity Loops!</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Fruits Page</h1>
		<div class="card-body">
		    <c:forEach var="fruit" items="${fruitsFromController}">
		        <h5>
			        <c:out value="${fruit.name}"></c:out>
			        <c:out value="${fruit.price}"></c:out>
		        </h5>
		    </c:forEach>
		</div>
	</div>
	
</body>
</html>