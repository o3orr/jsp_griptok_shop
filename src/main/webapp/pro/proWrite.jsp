<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 관리</title>
<link rel="stylesheet" type="text/css" href="css/shopping.css">
</head>
<body>
<jsp:include page="header.jsp" />
    <div id="wrap" align="center">
        <h1>상품 등록 - 관리자 페이지</h1>
        <form method="post" enctype="multipart/form-data" name="frm" action="ProServlet?command=pro_write">
            <table>
                <tr>
                    <th>상 품 명</th>
                    <td><input type="text" name="pname" size="80"></td>
                </tr>
                <tr>
                    <th>내 &nbsp;&nbsp;&nbsp; 용</th>
                    <td><input type="text" name="content"></td>
                </tr>
                <tr>
                    <th>가 &nbsp;&nbsp;&nbsp; 격</th>
                    <td><input type="text" name="price"></td>
                </tr>
                <tr>
                    <th>수 &nbsp;&nbsp;&nbsp; 량</th>
                    <td><input type="text" name="stock"></td>
                </tr>
                <tr>
                    <th>사 &nbsp;&nbsp;&nbsp; 진</th>
                    <td><input type="file" name="img"><br>
                        (주의사항 : 이미지를 변경하고자 할 때만 선택하시오)
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="등록">
            <input type="reset" value="다시 작성">
            <input type="button" value="목록" onclick="location.href='ProServlet?command=pro_list'">
        </form>
    </div>
</body>
</html>
