<%@ page import="com.techcrack.todo.todos.*, java.util.List" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			Todo-List
		</title>
	</head>
	<body>
		<h1>
			Todos Are : 
		</h1>
		<%
			List<Todo> todos = (List)request.getAttribute("todos");
		%>
		<% for (Todo t : todos) { %>
			<p><%=t %></p>
		<%} %>
		<form method="post">
			
		</form>
	</body>
</html>