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
<style>
img {
    width: 100px; /* 원하는 너비로 설정 */
    height: auto; /* 높이는 자동으로 조정되도록 설정 */
    display: block; /* 인라인 요소를 블록 요소로 변경하여 다른 요소와 수직으로 정렬 */
    margin: 0 auto; /* 가운데 정렬 */
}
</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/pro/header.jsp" />
	<div id="wrap" align="center">
		<h1>리뷰</h1>
		<c:forEach items="${ReviewList}" var="review">
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