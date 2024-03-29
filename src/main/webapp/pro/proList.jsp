<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mainPage.css">
<title>상품 관리</title>

</head>
<body>
   <!-- 헤더 파일 포함 -->
   <jsp:include page="header.jsp" />
   <div id="wrap" align="center">
      <h1>상품 리스트</h1>
      <hr>
      <div class="list">
         <!-- 상품 리스트 반복문 -->
         <c:forEach var="pro" items="${proList}">
            <div class="product">
               <!-- 상품 이미지와 상품 이름을 클릭했을 때 상세 페이지로 이동하는 링크 추가 -->
               <a href="ProServlet?command=pro_view&pid=${pro.pid}"> <img
                  class="product-img" src="upload/${pro.img}" alt="Product Image">
                  <div class="product-info">
                     <h3>${pro.pname}</h3>
                  </div>
               </a>
               <p class="product-price">${pro.price}원</p>
            </div>
         </c:forEach>
      </div>
   </div>
</body>
</html>
