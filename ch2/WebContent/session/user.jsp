<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>user 페이지</h2>
<h2>세션 객체에 담긴 값: <%=session.getAttribute("name") %></h2>
<h2>세션 객체에 담긴 값: <%=session.getAttribute("userid") %></h2>
<div>
<a href="main.jsp">메인 페이지</a>
</div>
<div>
<a href="section1.jsp">섹션 페이지</a>
</div>
<div>
<a href="session1.jsp">세션 페이지</a>
</div>
</body>
</html>