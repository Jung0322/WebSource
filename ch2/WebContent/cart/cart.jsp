<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>상품 리스트</h3>
	<form action="/add"method="post">
		<div>
			<input type="radio" name="product" id="EMW" value="BMW"/>BMW
		</div>
		<div>
			<input type="radio" name="product" id="SM5" value="SM5"/>SM5
		</div>
		<div>
			<input type="radio" name="product" id="Audi" value="Audi"/>Audi
		</div>
		<div>
			<input type="radio" name="product" id="K7" value="K7"/>K7
		</div>
		<div>
			<input type="submit" value="장바구니 추가" />
		</div>

	</form>
</body>
</html>