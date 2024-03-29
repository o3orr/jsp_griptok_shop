<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="script/product.js"></script>
<script type="text/javascript" src="script/order.js"></script>
<link rel="stylesheet" type="text/css" href="css/proview.css">
<title>상품 상세 정보</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container">
        <div class="project">
            <img src="${pageContext.request.contextPath}/upload/${pro.img}" alt="상품 이미지">
            <div class="detail-info">
                <div class="info-row">
                    <span class="info-label">상품명 : </span>
                    <span class="info-value">${pro.pname}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">내용 : </span>
                    <span class="info-value">${pro.content}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">가격 : </span>
                    <span class="info-value">${pro.price}</span>
                </div>
                <div class="info-row">
                    <span class="info-label">수량 : </span>
                    <span class="info-value">${pro.stock}</span>
                </div>
            </div>
            <div class="button-row">
                <c:choose>
                    <c:when test="${empty loginUser}">
                        <!-- 비회원인 경우 -->
                        <input type="button" class="button" value="로그인"
                            onclick="location.href='UserServlet?command=user_login_action'">
                        <input type="button" class="button" value="회원가입"
                            onclick="location.href='UserServlet?command=register_form'">
                    </c:when>
                    <c:otherwise>
                        <!-- 회원인 경우 -->
                        <c:choose>
                            <c:when test="${loginUser.is_admin eq 'Y'}">
                                <!-- 관리자인 경우 -->
                                <input type="button" class="button" value="상품 수정"
                                    onclick="editProduct(${pro.pid})">
                                <input type="button" class="button" value="상품 삭제"
                                    onclick="confirmDelete(${pro.pid})">
                            </c:when>
                            <c:otherwise>
                                <!-- 일반 사용자인 경우 -->
                                <input type="button" class="button" value="바로 구매하기"
                                    onclick="location.href='ProServlet?command=order_pay1_form&pid=${pro.pid}'">
                                <input type="button" class="button" value="장바구니"
                                    onclick="location.href='ProServlet?command=cart_list&id=${loginUser.id}&pid=${pro.pid }'">
                                <input type="button" class="button" value="리뷰"
                                    onclick="location.href='ProServlet?command=pro_review_list&pid=${pro.pid }'">
                                <input type="button" class="button" value="QnA"
                                    onclick="location.href='ProServlet?command=pro_QnA_list&pid=${pro.pid }'">
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
                <!-- 공통 버튼 -->
                <input type="button" class="button" value="상품 리스트"
                    onclick="location.href='ProServlet?command=pro_list'">
            </div>
        </div>
    </div>
</body>
</html>
