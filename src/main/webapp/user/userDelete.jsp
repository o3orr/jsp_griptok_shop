<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
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
        location.href='UserServlet?command=user_list';
    }
</script>
<title>게시글 수정</title>
</head>
<body>
    <div id="wrap" align="center">
        <h1>게시글 수정</h1>
        <form name="frm" method="post" action="UserServlet">
            <!-- <input type="hidden" name="command" value="user_update"> -->
            <%--  <input type="hidden" name="num" value="${user.num}"> --%>
            <table>
                <tr>
                    <th>이름</th>
                    <td>${user.username}</td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td>${user.email}</td>
                </tr>
                <!--  <tr>
                    <th>비밀번호</th>
                    <td><input type="password" size="12" name="pass"> * 필수 (게시물 수정 삭제시 필요합니다.)</td>
                </tr> -->
            </table>
            <br> <br> 
            <input type="button" value="수정" onclick="editRecord(${user.num})"> 
            <input type="button" value="삭제" onclick="deleteRecord(${user.num})"> 
            <input type="button" value="목록" onclick="goToListPage()">
        </form>
    </div>
</body>
</html>
