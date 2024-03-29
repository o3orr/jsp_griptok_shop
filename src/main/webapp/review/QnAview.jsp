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
        <c:choose>
            <c:when test="${loginUser.id eq QnADetail.id}">
                <!-- Only show delete and update buttons if the logged-in user is the author of this QnA -->
                <input type="button" value="QnA삭제" onclick="location.href='ProServlet?command=pro_QnA_delete&pid=${QnADetail.pid}&qa_id=${QnADetail.qa_id }'">
                <input type="button" value="QnA수정" onclick="location.href='ProServlet?command=pro_QnA_update_form&pid=${QnADetail.pid}&qa_id=${QnADetail.qa_id }'">
            </c:when>
            <c:otherwise>
                <!-- Show no buttons if the logged-in user is not the author of this QnA -->
            </c:otherwise>
        </c:choose>
        <table>
            <tr>
                <th>작 성 자</th>
                <td>${QnADetail.id}</td>
            </tr>
            <tr>
                <th>제 목</th>
                <td>${QnADetail.question_title}</td>
            </tr>
            <tr>
                <th>내 용</th>
                <td>${QnADetail.question}</td>
            </tr>
            <c:choose>
                <c:when test="${empty QnADetail.answer}">
                    <tr>
                        <th>답변 상태</th>
                        <td>${QnADetail.state}</td>
                    </tr>
                </c:when>
                <c:otherwise>
                    <tr>
                        <th>답변 상태</th>
                        <td>${QnADetail.state}</td>
                    </tr>
                    <tr>
                        <th>답 변</th>
                        <td>${QnADetail.answer}</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </table>

        <br> <br>
    </div>
</body>
</html>
