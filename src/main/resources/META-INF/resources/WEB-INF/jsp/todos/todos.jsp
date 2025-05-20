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
		
		<%@ include file="../common/footer.jspf"%>