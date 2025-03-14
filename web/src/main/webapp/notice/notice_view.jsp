<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%     
	//Controller에서 1차 클래스 배열값을 jsp에서 받아서 출력하는 방식
 	ArrayList<String> views = (ArrayList)request.getAttribute("notice_v");
	if(views == null){	//데이터가 없을 경우 script 발동 후 리스트 페이지로 이동
		out.print("<script> alert('올바른 접근이 아닙니다.'); location.href='./notice_list.do'; </script>");
	}
	else{	//null이 아닐 경우 html을 활성화

	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 내용 확인</title>
<style>
.data1{
width:400px;
height:30px;
line-height: 30px;
border-bottom: 1px solid #ccc;
}
.n{
	display: flex;
	flex-direction: row;
	justify-content: flex-start;
	align-content: center;
}
.data2{
border: 1px solid #333;
width:800px;
height:400px;
overflow-y:auto; 

}

</style>
</head>
<body>
<span class="n">등록일 : <div class="data1"><%=views.get(8)%></div></span>
<span class="n">조회수 : <div class="data1"><%=views.get(7)%></div></span>
<span class="n">제목 : <div class="data1"><%=views.get(1)%></div></span><br>
<span class="n">글쓴이 : <div class="data1"><%=views.get(2)%></div></span><br>
<span class="n">내용 : <div class="data2"><%=views.get(4)%></div></span><br>

<%
if(views.get(5) != null){		//첨부파일이 있을 경우만 작동되도록 설정
%>
<span class="n">첨부파일 : <div class="data1"><a href="../notice_file/<%=views.get(5)%>" target="_black"><%=views.get(5)%></a></div></span><br>
<%} %>
<br><br><br>
<!-- 패스워드 확인 후 데이터 삭제 -->
<form id="frm" method="post" action="./notice_delete.do">
<!-- 자동증가값을 hidden화 하여 form 전송-->
<input type="hidden" name="nidx" value="<%=views.get(0)%>">
<input type="hidden" name="ori_pw" value="<%=views.get(3)%>">
<!-- 사용자가 해당 게시물에 패스워드를 입력한 값 -->
패스워드 : <input type="password" name="npw">
</form>
<input type="button" value="목록" onclick="notice_info(1)">
<input type="button" value="수정" onclick="notice_info(2)">
<input type="button" value="삭제" onclick="notice_info(3)">

</body>

<% } %>
<script>

function notice_info(p){
	switch(p){
	case 1:
		location.href = './notice_list.do';
		break;
	case 2:
		location.href = './notice_modify.do';
		break;
	case 3:
	if(confirm("해당 게시물은 삭제 시 복구되지 않아요..")){
		if(frm.npw.value==""){
			alert("게시물을 삭제 하려면 비밀번호를 입력하셔야 합니다.");
		}
		else{
			frm.submit();
		}
	}
	break;
	}
}




</script>




</html>