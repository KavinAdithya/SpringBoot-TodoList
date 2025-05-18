			<%@ include file = "../common/header.jspf" %>			
			<%@ include file="../common/navigation.jspf" %>
			<div class="container">
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