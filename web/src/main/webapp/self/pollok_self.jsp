<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String subject = (String)request.getAttribute("subject");
	String etc[] = (String[])request.getAttribute("etc");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 참여 완료</title>
</head>
<body>
선택 과목 : <%=subject %> <br>
배우고 싶은 과목 : <%
int w = 0;
while(w < etc.length){
	out.print(etc[w] + ", ");
	w++;
}
%>

</body>
</html>