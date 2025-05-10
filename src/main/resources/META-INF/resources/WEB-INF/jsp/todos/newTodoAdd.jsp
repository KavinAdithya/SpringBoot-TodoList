<%@ page import="com.techcrack.todo.todos.*, java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>
			Add-Todo
		</title>
		 <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
		 
	</head>
	<body>
		<div class="container">
			<h1>Enter Todo Data : </h1>
			<form:form method="post" modelAttribute="todo">
				<label>Description : </label> <form:input type="text" path="description" required="true"/>
												<form:errors type="text" path="description"/><br><br>
				  
				<label>Target Date : </label> <form:input type="date" path="targetDate" required="true"/><br><br>
				<label>Is It Completed : </label> <form:input type="text" path="isDone" required="true"/><br><br>
			
				<input type="submit" class="btn btn-success"/>
			</form:form>
			
		</div>
		
		<script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>