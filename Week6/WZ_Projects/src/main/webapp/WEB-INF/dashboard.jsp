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
<title>Dashboard</title>

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
		<div class="m-3 d-flex justify-content-between card-heading text-center align-self-center">
			<h2>Welcome ${userLogin.name}</h2>
			
			<h2><a class="btn btn-danger" href="/logout">Logout</a></h2>
		</div>
		<div class="m-3 d-flex justify-content-between card-heading text-center align-self-center">
			<h4>All Projects</h4>
			
			<h4><a class="btn btn-info" href="/projects/new">Create New Project</a></h4>
		</div>

			<hr>
			<table class="m-3 table table-striped">
				<thead>
					<tr>
						<th>Project Name</th>
						<th>Due Date</th>
						<th>Created By</th>
						<th>Total Likes</th>
						<th>Like me!</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="project" items="${allProjects}">
						<tr>
							<td>
								<a href="/projects/${project.id}">
									<c:out value="${project.projectName}"/>
								</a>
							</td>
							<td><fmt:formatDate pattern = "yyyy-MM-dd" 
         value = "${project.dueDate}" /></td>
							<td><c:out value="${project.user.name}"/></td>
							<td>${project.userLikers.size()}</td> 
							<td>
								<c:choose>
									<c:when test="${project.userLikers.contains(userLogin)}">
										<a href="/project/dislike/${project.id}">Dislike</a>
									</c:when>
									<c:otherwise>
										<a href="/project/like/${project.id}">Like</a>
									</c:otherwise>
							     </c:choose>
							</td>
							<td>
								<c:if test="${project.user.id==userLogin.id}">
									<a class="btn btn-info" href="/projects/${project.id}/edits">Edit</a>
									<a class="btn btn-danger" href="/delete/project/${project.id}">Delete</a>
								</c:if>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>				
			</table>
		
	</div>
		
</body>
</html>