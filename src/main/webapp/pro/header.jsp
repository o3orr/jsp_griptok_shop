<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/header.css">
<script type="text/javascript" src="script/product.js"></script>
<title>헤더</title>
</head>
<body>
    <div id="header">
        <a href="ProServlet?command=pro_list"><img src="img/GRIP TOK.png" alt="로고 이미지"></a>
        <ul>
            <c:choose>
                <c:when test="${empty loginUser}">
                    <!-- 로그인되지 않은 경우 -->
                    <li><a href="UserServlet?command=user_login_action">로그인</a></li>
                    <li><a href="UserServlet?command=register_form">회원가입</a></li>
                </c:when>
                <c:otherwise>
                    <!-- 로그인된 경우 -->
                    <li><a href="UserServlet?command=logout_action">로그아웃</a></li>
                        <c:if test="${loginUser.is_admin eq 'Y'}">
                        <!-- 관리자 로그인 상태일 때 -->
                        <li><a href="ProServlet?command=pro_write_form">상품등록</a></li>
                        <li><a href="ProServlet?command=user_list">회원관리</a></li>
                    </c:if> 
                    <c:if test="${loginUser.is_admin eq 'N'}">
                        <!-- 일반 사용자 로그인 상태일 때 -->
                        <li><a href="ProServlet?command=cart_list&id=${loginUser.id}">장바구니</a></li>
                        <li><a href="ProServlet?command=my_Review&id=${loginUser.id}">리뷰</a></li>
                        <li><a href="ProServlet?command=my_QnA&id=${loginUser.id}">QnA</a></li>
                        <li><a href="UserServlet?command=mypage&id=${loginUser.id}">마이페이지</a></li>
                    </c:if>
                    <!-- 사용자 정보 표시 -->
                    <li class="user-info">${loginUser.username}님</li>
                </c:otherwise>
            </c:choose>

        </ul>
    </div>
</body>
</html>
