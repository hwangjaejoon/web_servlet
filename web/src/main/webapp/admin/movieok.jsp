<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String mname = (String)request.getAttribute("mname");
    String mno = (String)request.getAttribute("mno");
    String subject = (String)request.getAttribute("subject");
    String dt = (String)request.getAttribute("dt");
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>영화 예매 확인</p>
고객명 : <%=mname %><br>
연락처 : <%=mno %><br>
영화 선택 : <%=subject %><br>
예매일자 : <%=dt %><br><br>
<input type="button" value="예매 확정" onclick="gogogo()">

</body>
<script>
function gogogo(){
	alert("예매가 완료되었습니다.");
	location.href = ("movie.html");
}
</script>
</html>