<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mid = (String)request.getAttribute("mid");
String cou = (String)request.getAttribute("cou");


%> 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰등록 확인</title>
</head>
<body>
<p>쿠폰 등록 완료 페이지</p>
아이디 : <%=mid %><br><br>
쿠폰번호 : <%=cou %><br><br>
광고 수신 동의함
</body>
</html>