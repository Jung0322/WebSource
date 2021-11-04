<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div style="margin-top: 20px">
	<form action="/process/insertProcess.jsp" method="post">
		<div class="form-group">
			<label for="code">code</label> <input type="text"
				placeholder="code" class="form-control" id="code" required="required" name="code">
		</div>
		<div class="form-group">
			<label for="title">title</label> <input type="text" placeholder="title"
				class="form-control" id="title"required="required" name="title">
		</div>
		<div class="form-group">
			<label for="writer">writer</label> <input type="text" placeholder="writer"
				class="form-control" id="writer"required="required" name="writer">
		</div>
		<div class="form-group">
			<label for="price">price</label> <input type="text"
				placeholder="price" class="form-control" id="price"required="required" name="price">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
</body>
</html>