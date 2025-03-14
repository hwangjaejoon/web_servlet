<%@page import="mallpage.dto_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function errmsg(){
		alert("상품정보가 올바르지 않습니다.");
		location.href='./product_list.do';
	}
</script>
<%

	//DTO Model을 Controller에서 받은 값을 이관시켜서 해당 메소드로 값을 출력 하기 위한 방식
	dto_product pd = (dto_product)request.getAttribute("dto");
	if(pd.getMidx() == 0){
		out.print("<script> errmsg(); </script>");
	}
	// out.print(pd.getPnm());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
<!-- DTO Getter 메소드를 출력 순서에 맞게 적용  -->
<img src=".<%=pd.getPimg()%>"><br>
상품명 : <%=pd.getPnm()%><br>
상품 가격 : <%=pd.getPmoney()%><br>
<% if(!pd.getPsales().equals("0")){ %>
할인율 : <%=pd.getPsales()%><br>
할인 가격 : <%=pd.getPsmoney()%><br>
<% }%>
<input type="button" value="목록" onclick="location.href='./product_list.do'">
<!-- JSP => Javascript => JAVA 순서로 작동 -->
</body>

</html>