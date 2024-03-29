<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/myQnAList.css">
<script type="text/javascript" src="script/product.js"></script>

<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/pro/header.jsp" />
	<div id="wrap" align="center">
		<h1>My Review</h1>
		<c:forEach items="${MyReviewList}" var="review">
			<table>
				<tr>
					<th>작 성 자</th>
					<td>${review.id }</td>

				</tr>
				<tr>
					<th>별 점</th>
					<td>${review.rating }</td>
				</tr>

				<tr>
					<th>내 용</th>
					<td>${review.content }</td>
				</tr>

				<tr>
					<th>사 진</th>
					<td><img
						src="${pageContext.request.contextPath}/upload/${review.img}"
						alt="상품 이미지"></td>
				</tr>

			</table>
			<hr>
		</c:forEach>
		<br> <br>
	</div>
</body>
</html>