<%@ page import="com.techcrack.todo.todos.*, java.util.List" %>
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
			<h1>
				Welcome To Tech-Crack Universe !
			</h1>
			<h1>
				You're Todos Are : 
			</h1>
			<table class="table">
				<thead>
					<tr>
						<th>Id</th>
						<th>Description</th>
						<th>TargetDate</th>
						<th>IsDone</th>
						<th>Delete</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="todo" items="${todos}" varStatus="loop">
						<tr>
							<td>${loop.index + 1}</td>
							<td>${todo.description}</td>
							<td>${todo.targetDate}</td>
							<td>${todo.isDone}</td>
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