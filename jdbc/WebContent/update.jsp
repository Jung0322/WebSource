<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/layout/header.jsp"%>

<div style="margin-top: 20px">
	<form action="updateProcess.jsp" method="post">
		<div class="form-group">
			<label for="userid">userid</label> <input type="text" placeholder="아이디"
				class="form-control" id="userid" name="userid">
		</div>
		<div class="form-group">
			<label for="currentPassword">Password</label> <input type="password" placeholder="현재비밀번호"
				class="form-control" id="currentPassword" name="currentPassword">
		</div>
		<div class="form-group">
			<label for="changePassword">Changed Password</label> <input type="password" placeholder="변경비밀번호"
				class="form-control" id="changePassword" name="changePassword">
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>
<%@ include file="/layout/footer.jsp"%>