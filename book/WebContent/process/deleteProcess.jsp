<%@page import="book.persistence.BookDAO"%>
<%@page import="book.persistence.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
   String code = request.getParameter("code");
   

   Connection con = JdbcUtil.getConnection();
   BookDAO dao = new BookDAO(con);
   boolean deleteFlag = dao.detele(code);
   
   
   
   
   String path="/index.jsp";
   if(deleteFlag){
      JdbcUtil.commit(con);
      path +="?tab=all";
   }else{
      JdbcUtil.rollback(con);
      path +="?tab=delete";
   }
   JdbcUtil.close(con);
   response.sendRedirect(path);
   
%>