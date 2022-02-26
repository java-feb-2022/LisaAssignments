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
<title>TEMPLATE</title>
</head>
<body>
	
	<h1>Customer name</h1>
	<h3>Item name: <c:out value="${first}"/></h3>
	<h3>Price: $ <c:out value="${price}"/></h3>
	<h3>Description: <c:out value="${description}"/></h3>
	<h3>Vendor: <c:out value="${vendor}"/></h3>
	
</body>
</html>