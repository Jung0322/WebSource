<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<form action="/process/modifyProcess.jsp" method="post">
		<div class="form-group">
			<label for="code">code</label> <input type="text" placeholder="code"
				class="form-control" id="code" required="required" name="code">
		</div>
		<div class="form-group">
			<label for="price">price</label> <input type="text"
				placeholder="price" class="form-control" id="price"required="required" name="price">
		</div>
		<button type="submit" class="btn btn-primary">수정</button>
	</form>