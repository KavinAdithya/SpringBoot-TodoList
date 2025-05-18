		<%@ include file="../common/header.jspf" %>
		<%@ include file="../common/navigation.jspf" %>
		<div class="container">
			
			<h1>Enter Todo Data : </h1>
			<form:form method="post" modelAttribute="todo">
		
				<fieldset class="mb-3">
					<form:label path="description">Description : </form:label>
					<form:input type="text" path="description" required="true"/>
					<form:errors cssStyle="color:red;" type="text" path="description"/>
				</fieldset>
				 
				<fieldset class="mb-3">
					<form:label path="targetDate">Target Date : </form:label> 
					<form:input path="targetDate" required="true"/>
				</fieldset>
				  
				<fieldset class="mb-3">
					<form:label path="isDone">Is It Completed : </form:label> 
					<form:input type="text" path="isDone" required="true"/>
				</fieldset>
				
			
				<input type="submit" class="btn btn-success"/>
			</form:form>
			
		</div>
		
		<script type="text/javascript" src="/webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="/webjars/jquery/3.6.0/jquery.min.js"></script>
		<script type="text/javascript" src="/webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
		
		<script type="text/javascript">
			$('#targetDate').datepicker ({
				format:'mm/dd/yyyy'
			});
		</script>
	</body>
</html>