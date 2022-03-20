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
<title>New Dojo Form</title>
<!-- BOOTSTRAP HEADERS -->
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script type="text/javascript" src="js/app.js"></script>

<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="card container">
	
		<h1>New Ninja</h1>
		<form:form action="/ninjas" method="post" modelAttribute="ninja">
		
		    <p>
		        <form:label path="firstName">First Name:</form:label>
		        <form:input path="firstName"/>
		    </p>
		    
		    <p>
		        <form:label path="lastName">Last Name:</form:label>
		        <form:input path="lastName"/>
		    </p>
		    <p>
		        <form:label path="age">Age:</form:label>
		        <form:input path="age"/>
		    </p>
		    
		    <p>
		        <form:label path="dojo">Dojo:</form:label>
		        
		        <form:select path="dojo">
		        
		        	<c:forEach var="eachDojo" items="${dojos}">
			        
			        	<option value="${eachDojo.id}"><c:out value="${eachDojo.name}"/></option>
			        
		        	</c:forEach>
		        	
		        </form:select>
		    </p>
		    
		    
		    <input type="submit" value="Submit"/>
		    
		</form:form>
	
	</div>
</body>
</html>