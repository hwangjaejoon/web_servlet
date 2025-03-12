<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./subpage.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>
<body>
  					<!-- 상단 로고 & 메뉴 -->

    	<%@ include file="./top.jsp" %>

					<!-- 상단 로고 & 메뉴 끝 -->
					
<main>
  					<!-- 로그인 화면 -->

    	<%@ include file="./login_view.jsp" %>

					<!-- 로그인 화면 끝 -->
</main>

<footer>
					<!-- 카피라이터 및 하단 -->
		<%@ include file="./footer.jsp" %>
					<!-- 카피라이터 및 하단 끝-->
</footer>
</body>
</html>