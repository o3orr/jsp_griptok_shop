<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/userlist.css">
<title>게시글 리스트</title>
</head>
<body>
    <div id="wrap" align="center">
        <h1>게시글 리스트</h1>
        <table class="list">
            <tr>
                <th>아이디</th>
                <th>이름</th>
                <th>전화번호</th>                
                <th>이메일</th>
                <th>가입일</th>
                <th>주소</th>
                <th>상세주소</th>
        
            </tr>
            <c:forEach var="user" items="${userlist}">
                <tr class="record">
                    <c:choose>
                        <c:when test="${user.num != null}">
                            <td><a href="UserServlet?command=user_view&num=${user.num}">${user.id}</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="#">ID not available</a></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${user.username}</td>
                    <td>${user.phone}</td>
                    <td>${user.email}</td>
                    <td><fmt:formatDate value="${user.registration_date}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                    <td>${user.addr}</td> <!-- 사용자의 주소를 표시 -->
                    <td>${user.addr2}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
