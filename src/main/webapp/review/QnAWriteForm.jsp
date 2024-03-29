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
		<h1>QnA</h1>
		<form method="post" action="ReviewServlet">
			<input type="hidden" name="command" value="pro_QnA_write"> 
			<input type="hidden" name="pid" value="${pid }"> 
			<input type="hidden" name="state" value="대기">
			<table>
				<tr>
					<th>작 성 자</th>
					<td><input type="text" name="id" value="${loginUser.id }" readonly>
					</td>
				</tr>
				<tr>
					<th>제 목</th>
					<td><input type="text" name="question_title"></td>
				</tr>
				<tr>
					<th>내 용</th>
					<td><input type="text" name="question"></td>
				</tr>

			</table>
			<input type="submit" class="button" value="등록"> 
			<input type="reset" class="button" value="다시쓰기">
		</form>

		<br> <br>
	</div>
</body>
</html>
