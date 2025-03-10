<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HttpSession hs = request.getSession();
	hs.invalidate();	//session 의 모든 값을 삭제
	out.print("<script>alert('로그아웃 되었습니다.');location.href='./login.jsp';</script>");

%>
