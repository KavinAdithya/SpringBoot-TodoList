<%@ page import="com.techcrack.todo.todos.*, java.util.List, java.time.format.DateTimeFormatter, java.time.LocalDate" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			Todo-List
		</title>
		 <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
		 
	</head>
	<body>
		<div class="container">
			<nav class="navbar navbar-expand-md navbar-light bg-light mb-3 p-1">
				<a class="navbar-brand m-1" href="#">Techcrack</a>
				<div class="collapse navbar-collapse">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" href="/todos/home">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="/todos/todo-list">Todos</a></li>
					</ul>
				</div>
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
				</ul>	
			</nav>
			
			<h1>
				Welcome To Tech-Crack Universe !
			</h1>
			<h1>
				You're Todos Are : 
			</h1>
			
			<table class="table">
				<thead>
					<tr>
						<th>Description</th>
						<th>TargetDate</th>
						<th>IsDone</th>
						<th>Update</th>
						<th>Delete</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${todos}" varStatus="loop">
						<tr>
							<td>${todo.description}</td>
							<td>${todo.formatedDate}</td>
							<td>${todo.isDone}</td>
							
							<td> <a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a>
							<td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a href="/todos/add-todo" class="btn btn-success">Add Todo </a>
			
			
			<form method="post">
				
			</form>
		
		</div>
		
		<script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>