<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//out.print 출력할 때 null로 출력이 될 경우(session) ==> 연산기호 사용 [==null]

	HttpSession hs = request.getSession();
	String mid = (String)hs.getAttribute("mid");
	String mnm = (String)hs.getAttribute("mnm");
	if(mid!=null || mnm!=null){
		out.print("<script>alert('이미 로그인 하셨습니다.'); location.href='./main.jsp';</script>");
	}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<form id="frm" method="post" action="./shop_loginok.do" onsubmit="return loginck()">
<p>[회원 로그인]</p>
<div>
<label>
<input type="radio" value="P" name="spart" checked onclick="partcheck(this.value)">일반회원 </label>
<label>
<input type="radio" value="C" name="spart" onclick="partcheck(this.value)">사업자 회원 <br><br>
</label>
<input type="text" name="sid" placeholder="아이디를 입력하세요"><br><br>
<input type="password" name="spw" placeholder="비밀번호를 입력하세요"><br><br>
<span id="snoview" style="display:none;">
<input type="text" name="sno" placeholder="사업자 등록번호"><br><br>
</span>
<input type="submit" value="로그인"><br>
</div>
</form>
</body>
<script src="./login.js?v=2"></script>
</html>