<%@ page import="com.techcrack.todo.todos.*" %>
<!DOCTYPE html>
<html>
	<head>
		<title>
			Todo-Techcrack
		</title>
	</head>
	<body>
		<h1>
			Welcome ${name} To Tech-Crack Universe !
		</h1>
		<% for (Todo t : todos) { %>
			<p>t</p>
		<%} %>
		<form method="post">
			
		</form>
	</body>
</html>