<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
	String mpay = (String)request.getAttribute("mpay");
	String mtotal = (String)request.getAttribute("mtotal");
	int fin = 0;
if(mpay.equals("무통장 입금")) {
	fin ++;
}

%>
<html>
<head>
<meta charset="UTF-8">
<title>최종 결제 확인</title>
</head>
<body>


<form id="frm" method="post" action="./mallok.jsp">
최종 결제 금액 : <%=mtotal%><br>
결제수단 : <%=mpay%><br><br>

<% if(fin == 1){ %>
계좌번호 : 02-1234-56789<br>
입금자명 : <input type="text" id="mname"><br><br>
<% } %>
<input type="button" value="결제완료" onclick="paypay()">
</form>




</body>
<script>
	function paypay() {
		var fin = <%=fin%>;
		if (fin == 0) {
			frm.submit();
		} else {
			if (frm.mname.value == "") {
				alert("고객명을 입력해 주세요.");
			} else {
				frm.submit();
			}
		}
	}
</script>
</html>