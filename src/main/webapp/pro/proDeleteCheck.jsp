<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/shopping.css">
<title>삭제 확인</title>
</head>
<body>
    <div align="center">
        <h1>삭제 확인</h1>
        <form action="ProServlet" name="frm" method="get">
            <input type="hidden" name="command" value="pro_check_delete">
            <input type="hidden" name="num" value="${param.pid}">
            <table style="width: 80%">
                <tr>
               
                    <th>상품 번호</th>
                    <td><input type="text" name="pid" size="20"></td>
                </tr>
            </table>
            <br> 
            <input type="submit" value="확인"> <br> <br>
            ${message}
        </form>
    </div>
</body>
</html>
