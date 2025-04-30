<%@ page import="com.techcrack.todo.todos.*, java.util.List" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
			<form method="post">
				<label>Description : </label> <input type="text" name="description"/>
				<input type="submit" class="btn btn-success"/>
			</form>
			
		</div>
		
		<script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>