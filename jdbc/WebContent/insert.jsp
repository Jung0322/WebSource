<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>

<div style="margin-top: 20px">
	<form action="insertProcess.jsp" method="post">
		<div class="form-group">
			<label for="userid">userid</label> <input type="text"
				placeholder="아이디" class="form-control" id="userid" required="required" name="userid">
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input type="password"
				placeholder="현재비밀번호" class="form-control" id="password"required="required" name="password">
		</div>
		<div class="form-group">
			<label for="name">Name</label> <input type="text" placeholder="이름"
				class="form-control" id="name"required="required" name="name">
		</div>
		<div class="form-group">
			<label for="gender">성별</label> <input type="text" placeholder="성별"
				class="form-control" id="gender"required="required" name="gender">
		</div>
		<div class="form-group">
			<label for="email">email</label> <input type="email"
				placeholder="이메일" class="form-control" id="email"required="required" name="email">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="/layout/footer.jsp"%>