<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
</head>
<body>
	<form action="joinProcess.jsp">
		<div class="form-group">
			<label for="userid">아이디</label> <input type="text"
				class="form-control" id="userid" name="userid">
		</div>
		<div class="form-group">
			<label for="password">비밀번호</label> <input type="password"
				class="form-control" id="password" name="password">
		</div>
		<div class="form-group">
			<label for="passwordCon">비밀번호 확인</label> <input type="password"
				class="form-control" id="passwordCon" name="passwordCon">
		</div>
		<div class="form-group">
			<label for="name">이름</label> <input type="text" class="form-control"
				id="name" name="name">
		</div>
		</div>
		<div class="form-group">
			<label for="email">이메일</label> <input type="email"
				class="form-control" id="email" name="email">
		</div>
		<div class="form-group">
			<label for="gender">성별</label> <input type="radio" name="gender"
				value="남성" />남성 <input type="radio" name="gender" value="여성" />여성
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>