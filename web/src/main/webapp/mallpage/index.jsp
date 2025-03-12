<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>
<meta charset="UTF-8">
  <body>
  					<!-- 상단 로고 & 메뉴 -->

    	<%@ include file="./top.jsp" %>

					<!-- 상단 로고 & 메뉴 끝 -->
 <main>
					<!--  배너 -->
    	<%@ include file="./banner.jsp" %>
					<!--  배너 끝 -->
					<!-- 신상품 -->
		<%@ include file="./product.jsp" %>
					<!-- 신상품 끝-->
</main>
<footer>
					<!-- 카피라이터 및 하단 -->
		<%@ include file="./footer.jsp" %>
					<!-- 카피라이터 및 하단 끝-->
</footer>
  </body>
</html>