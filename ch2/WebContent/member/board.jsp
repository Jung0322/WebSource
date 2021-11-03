<%@page import="user.domain.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   //세션에 담긴값 가져오기
   
   UserDTO loginDTO =(UserDTO)session.getAttribute("loginDTO");

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>board 페이지</h1>
<h2><%= loginDTO.getName() %>님 반갑습니다.</h2>
</body>
</html>