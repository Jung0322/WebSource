<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

request.setCharacterEncoding("utf-8");
   String userid = request.getParameter("userid");
   String password = request.getParameter("password");
   String passwordcon = request.getParameter("passwordCon");
   String name = request.getParameter("name");
   String email = request.getParameter("email");
   String gender = request.getParameter("gender");
   
   out.print("<br>id: "+userid);
   out.print("<br>password: "+password);
   out.print("<br>비밀번호 확인: "+passwordcon);
   out.print("<br>이름: "+name);
   out.print("<br>이메일: "+email);
   out.print("<br>성별: "+gender);
   %>