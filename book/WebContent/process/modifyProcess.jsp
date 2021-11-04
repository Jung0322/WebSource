<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.persistence.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");

//modify.jsp 넘긴 값 가져오기
String code = request.getParameter("code");
String price = request.getParameter("price");
//db작업
Connection con = JdbcUtil.getConnection();
BookDAO dao = new BookDAO(con);
boolean updateFlag = dao.update(code, Integer.parseInt(price));

//페이지 이동
 String path="/index.jsp";
if (updateFlag) {
	JdbcUtil.commit(con);
	path += "?tab=all";
} else {
	JdbcUtil.rollback(con);
	path += "?tab=modify";
}
JdbcUtil.close(con);
response.sendRedirect(path);
%>
