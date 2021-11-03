<%@page import="java.util.Arrays"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자의 요청을 가져올 떄 request로 처리
	//사용자의 요청은 무조건 String 형태임
	
	//post 방식 한글깨짐 방지
	//asdss
	request.setCharacterEncoding("utf-8");
	
	String username = request.getParameter("username");
	String age = request.getParameter("age");
	String gender =  request.getParameter("gender");
	String fruits[] = request.getParameterValues("fruits");

	String page1=request.getParameter("page");
	String bno=request.getParameter("bno");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>이름 : <%=username %> : <%=age %> : <%=gender %> : <%=Arrays.toString(fruits) %></h3>
<h3> <%=page1 %> : <%=bno %></h3>
</body>
</html>