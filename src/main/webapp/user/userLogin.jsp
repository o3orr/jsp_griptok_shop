<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사용자 로그인</title>
    <link rel="stylesheet" type="text/css" href="css/login.css"> <!-- 스타일 시트 경로를 적절히 수정하세요 -->
</head>
<body>
    <div class="container">
        <h2>사용자 로그인</h2>
        <form action="UserServlet" method="post">
            <input type="hidden" name="command" value="user_login">
            <div class="input-group">
                <label for="id">아이디:</label>
                <input type="text" id="id" name="id" required>
            </div>
            <div class="input-group">
                <label for="pass">비밀번호:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            <div class="input-group">
                <input type="submit" value="로그인">
                <input type="reset" value="취소">
            </div>
        </form>
        <p>아직 회원이 아니신가요? <a href="UserServlet?command=register_form">회원가입</a></p>
    </div>
</body>
</html>
