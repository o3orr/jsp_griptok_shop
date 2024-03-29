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
		<h1>QnA</h1>
		<c:if test="${not empty loginUser and not empty loginUser.id}">
			<input type="button"class="button" value="QnA등록" onclick="location.href='ProServlet?command=pro_QnA_write_form&pid=${pid}'">
		</c:if>
		<c:forEach items="${QnAList}" var="qa">
			<table onclick="location.href='ProServlet?command=pro_QnA_view&pid=${qa.pid}&qa_id=${qa.qa_id }'">
				<tr>
					<th>작 성 자</th>
					<td>${qa.id}</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td>${qa.question_title}</td>
				</tr>
			</table>
			<hr>
		</c:forEach>
		<br> <br>
	</div>
</body>
</html>