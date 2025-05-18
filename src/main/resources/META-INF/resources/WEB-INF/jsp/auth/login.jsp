<!DOCTYPE html>
<html>
	<head>
		<title>
			Login-Todo
		</title>
		<link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css"/>
	</head>
	<body>
		<%@ include file="../common/navigation.jspf" %>
		<div class="container">
			<h1>Authentication</h1>
			<pre style="color:red;">${error}</pre>
			<form method="post">
				Name : <input type="text" name="name" required/><br><br>
				Password : <input type="password" name="password" required/><br><br>
				<input type="submit"/>
			</form>
		</div>
		<script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/webjars/jquery/3.6.0/jquery.min.js"></script>
	</body>
</html>