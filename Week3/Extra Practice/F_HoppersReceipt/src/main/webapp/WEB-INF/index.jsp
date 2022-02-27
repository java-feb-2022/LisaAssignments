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
	<title>TEMPLATE</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
	<div class="card container">
		<h1 class="card-header">Customer name</h1>
		<div class="card-body">
			<h5 class="card-text">Item name: <c:out value="${first}"/></h3>
			<h5 class="card-text">Price: $ <c:out value="${price}"/></h3>
			<h5 class="card-text">Description: <c:out value="${description}"/></h3>
			<h5 class="card-text">Vendor: <c:out value="${vendor}"/></h3>
		</div>
	</div>
	
</body>
</html>