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
	<title>Form Submission</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <h3>Login</h3>
    <form action='/login' method='post'>
		<div>
			<label>Email:</label>
	    	<input type="text" name='email'>
		</div>
		<div>
			<label>Password:</label>
	    	<input type='text' name='password'>
	    	<input type='submit' value='login'>
	    </div>
    </form>	
    <h3>Pay</h3>
    <form action="/processPayment" method="post">
        <input type="hidden" name="productID" value="128">
        <label>Credit Card Number</label>
        <input type="text" name="creditCardNumber">
        <label>Expiration Date</label>
        <input type="date" name="expDate">
        <input type="submit">
    </form>
    
</body>
</html>