<%@ include file="../common/header.jspf" %>
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
<%@ include file="../common/footer.jspf"%>