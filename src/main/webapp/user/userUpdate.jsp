<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/userUpdate.css">
<title>게시글 수정</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>회원 수정</h1>
		<form name="frm" method="post" action="UserServlet">
			<input type="hidden" name="command" value="user_update"> <input
				type="hidden" name="num" value="${user.num}">
			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" size="12" name="username"
						value="${user.username}"> * 필수</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type="text" size="12" name="phone"
						value="${user.phone}"> * 필수</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="40" maxlength="50" name="email"
						value="${user.email}"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" size="12" name="pass"> * 필수
						(게시물 수정 삭제시 필요합니다.)</td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input id="member_post" type="text" placeholder="우편번호"
						name="postcode" readonly> <input id="member_addr"
						type="text" placeholder="주소" name="addr" readonly> <input
						id="member_addr2" type="text" placeholder="상세주소" name="addr2">
						<input type="button" value="주소 찾기" onclick="findAddr()"></td>
				</tr>
			</table>
			<br> <br> <input type="submit" value="등록"> <input
				type="reset" value="다시 작성"> <input type="button" value="목록"
				onclick="location.href='UserServlet?command=user_list'">
		</form>
	</div>
	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
		function findAddr() {
			new daum.Postcode(
					{
						oncomplete : function(data) {
							var roadAddr = data.roadAddress; // 도로명 주소 변수
							var jibunAddr = data.jibunAddress; // 지번 주소 변수

							document.getElementById('member_post').value = data.zonecode;
							if (roadAddr !== '') {
								document.getElementById("member_addr").value = roadAddr;
							} else if (jibunAddr !== '') {
								document.getElementById("member_addr").value = jibunAddr;
							}
						}
					}).open();
		}
	</script>
</body>
</html>
