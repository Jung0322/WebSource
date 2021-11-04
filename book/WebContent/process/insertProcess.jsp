<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="book.domain.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
//insert.jsp에서 넘긴 값 가져오기
BookDTO insertDto = new BookDTO();
insertDto.setCode(request.getParameter("code"));
insertDto.setWriter(request.getParameter("writer"));
insertDto.setTitle(request.getParameter("title"));
insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
//db작업
Connection con = JdbcUtil.getConnection();
BookDAO dao = new BookDAO(con);

boolean insertFlag = dao.insert(insertDto);

//페이지 작업
String path="/index.jsp";
if (insertFlag) {
	JdbcUtil.commit(con);
	path += "?tab=all";
} else {
	JdbcUtil.rollback(con);
	path += "?tab=insert";
}

JdbcUtil.close(con);
response.sendRedirect(path);
%>