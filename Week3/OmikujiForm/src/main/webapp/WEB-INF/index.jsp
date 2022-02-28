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
	<title>Omikuji</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<body>
    <h3>Form Omikuji</h3>
    <form action='/processForm' method='post'>
		<div class="mb-3">
			<label class="form-label">Pick any number from 5 to 25:</label>
	    	<input class="form-control" type="number" name="randNumber">
		</div>
		<div class="mb-3">
			<label class="form-label">Enter the name of any city:</label>
	    	<input class="form-control" type="text" name="cityName">
		</div>
		<div class="mb-3">
			<label class="form-label">Enter the name of any real person:</label>
	    	<input class="form-control" type="text" name="personName">
		</div>
		<div class="mb-3">
			<label class="form-label">Enter hobby:</label>
	    	<input class="form-control" type="text" name="hobby">
		</div>
		<div class="mb-3">
			<label class="form-label">Enter any type of living thing:</label>
	    	<input class="form-control" type="text" name="livingThing">
		</div>
		<div class="mb-3">
			<label class="form-label">Say something nice to someone:</label>
	    	<input class="form-control" type="text" name="somethingNice">
		</div>
		<div>
			<label>Send and show a friend:</label>
			<input class="btn btn-danger" type='submit' value='Submit'>
	    </div>
    </form>	
	
</body>
</html>