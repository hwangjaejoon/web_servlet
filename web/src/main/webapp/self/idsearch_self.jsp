<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mid = (String)request.getAttribute("mid");	//어....mid 값 자바에서 받기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
</head>
<body>
회원 아이디 : <%=mid%>
</body>
</html>