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
		<h1>My QnA</h1>
		<c:forEach items="${MyQnAList}" var="QnA">
			<table>
				<tr>
					<th>작 성 자</th>
					<td>${QnA.id }</td>

				</tr>
				<tr>
					<th>제 목</th>
					<td>${QnA.question_title }</td>
				</tr>

				<tr>
					<th>내 용</th>
					<td>${QnA.question }</td>
				</tr>
				<c:choose>
					<c:when test="${empty QnA.answer}">
						<tr>
							<th>답변 상태</th>
							<td>${QnA.state}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<th>답변 상태</th>
							<td>${QnA.state}</td>
						</tr>
						<tr>
							<th>답 변</th>
							<td>${QnA.answer}</td>
						</tr>
					</c:otherwise>
				</c:choose>

			</table>
			<hr>
		</c:forEach>
		<br> <br>
	</div>
</body>
</html>