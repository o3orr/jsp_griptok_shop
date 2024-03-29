<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
	<div id="wrap" align="center">
		<h1>게시글 수정</h1>

		<form name="frm" method="post" enctype="multipart/form-data"
			action="ProServlet">
			<input type="hidden" name="command" value="pro_update"> <input
				type="hidden" name="pid" value="${pro.pid}">
			<table>

				<tr>
					<td><c:choose>
							<c:when test="${empty pro.img}">
								<img src="upload/noimage.gif">
							</c:when>
							<c:otherwise>
								<img src="upload/${pro.img}">
							</c:otherwise>
						</c:choose> </td>
					<td>
						<table>
							<tr>
								<th>상 품 명</th>
								<td><input type="text" size="12" name="pname"
									value="${pro.pname}"> * 필수</td>
							</tr>
							<tr>
								<th>내 용</th>
								<td><input type="text" size="50" name="content"
									value="${pro.content} "></td>
							</tr>
							<tr>
								<th>가 격</th>
								<td><input type="text" size="12" name="price"
									value="${pro.price}"></td>
							</tr>
							<tr>
								<th>수 량</th>
								<td><input type="text" size="12" name="stock"
									value="${pro.stock }"></td>
							</tr>
							<tr>
								<th>사 진</th>
								<td><input type="file" name="img"><br> (주의사항 :
									이미지를 변경하고자 할때만 선택하시오)</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록"> <input
				type="reset" value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='ProServlet?command=pro_list'">
		</form>
	</div>
</body>
</html>