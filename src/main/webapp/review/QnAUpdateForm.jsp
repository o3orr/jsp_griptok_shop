<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<script type="text/javascript" src="script/product.js"></script>

<style>
button {
    background-color: #7B68EE;
    color:#fff;
    border: none;
    border-radius: 15px;
    padding: 15px 30px; /* 버튼 내부 여백을 늘립니다. */
    margin: 0 10px; /* 버튼 간격을 조정합니다. */
    cursor: pointer;
    transition: background-color 0.3s ease;
    font-size: 1.4em; /* 버튼의 글꼴 크기를 더 크게 설정 */
    font-family: 'East Sea Dokdo', sans-serif;
}

</style>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/pro/header.jsp" />
	<div id="wrap" align="center">
		<h1>QnA</h1>
		<form method="post" action="ReviewServlet">
			<input type="hidden" name="command" value="pro_QnA_update"> <input
				type="hidden" name="pid" value="${QnA.pid}"> <input
				type="hidden" name="qa_id" value="${QnA.qa_id}"> <input
				type="hidden" name="state" value="대기">
			<table>
				<tr>
					<th>작 성 자</th>
					<td><input type="text" name="id" value="${loginUser.id }" readonly>
					</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td><input type="text" name="question_title"
						value="${QnA.question_title}"></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><input type="text" name="question" value="${QnA.question}"></td>
				</tr>

			</table>
			<input type="submit" value="수정"> <input type="reset"
				value="다시쓰기">
		</form>


		<br> <br>
	</div>
</body>
</html>
