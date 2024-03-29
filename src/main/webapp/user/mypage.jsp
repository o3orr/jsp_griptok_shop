<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/mypage.css">
<script>
function editRecord(num) {
    location.href='UserServlet?command=user_update_form&num=' + num;
}

function deleteRecord(num) {
    var result = confirm("정말로 이 사용자를 삭제하시겠습니까?");
    if (result) {
        // 확인을 눌렀을 때만 삭제 요청 보내기
        window.location.href = 'UserServlet?command=user_delete&num=' + num;
    } else {
        // 취소했을 경우
        alert("삭제가 취소되었습니다.");
    }
}

function goToListPage() {
    location.href='ProServlet?command=pro_list';
}
</script>
<title>게시글 수정</title>
</head>
<body>
	<div id="wrap" align="center">
		<h1>회원 수정</h1>
		<form name="frm" method="post" action="UserServlet">
			<!-- <input type="hidden" name="command" value="user_update"> -->
			<%--     <input type="hidden" name="num" value="${user.num}"> --%>
			<table>
				<tr>
					<th>이름</th>
					<td>${loginUser.username}</td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td>${loginUser.phone}</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>${loginUser.email}</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>${loginUser.addr}</td>
				</tr>
				<tr>
					<th>상세주소</th>
					<td>${loginUser.addr2}</td>
				</tr>
			</table>
			<br> <br> <input type="button" value="수정"
				onclick="editRecord(${loginUser.num})"> 
				<input type="button" value="삭제" onclick="deleteRecord(${loginUser.num})"> 
				<input type="button" value="목록" onclick="goToListPage()">
		</form>
	</div>
</body>
</html>
