<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>장바구니</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <h1>장바구니</h1>
    
    <c:if test="${empty cartList}">
        <p>장바구니에 담긴 상품이 없습니다.</p>
    </c:if>
    
    <c:if test="${not empty cartList}">
        <form id="cartForm" action="ProServlet" method="post">
                    <input type="hidden" name="command" value="delete_cart_items">
            <table border="1">
                <tr>
                    <th>선택</th>
                    <th>상품명</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>삭제</th>
                </tr>
                <c:forEach var="cartItem" items="${cartList}">
                    <tr class="record">
                        <td>
                            <input type="checkbox" name="selectedOrders" value="${cartItem.cart_id}">
                            <input type="hidden" name="selectedOrderIds" value="${cartItem.cart_id}">
                        </td> 
                        <td>${proList.pname}</td>
                        <td>${proList.price}</td>
                        <td>${proList.stock}</td>
                    </tr>
                </c:forEach>
            </table>
            <input type="button" value="선택 상품 삭제" onclick="deleteSelectedItems()">
        </form>
    </c:if>
    
    <a href="ProServlet?command=pro_list">계속 쇼핑하기</a>
    <a href="ProServlet?command=order_pay1_form">주문하기</a>
    
    <script>
        var selectedItems = []; // 선택된 상품을 저장할 배열
        
        // 상품 삭제 함수
        function deleteItem(itemId) {
            if (confirm('정말 삭제하시겠습니까?')) {
                document.getElementById('cartForm').innerHTML += '<input type="hidden" name="deleteItemId" value="' + itemId + '">';
                document.getElementById('cartForm').submit();
            }
        }
        
        // 선택된 상품 삭제 함수
        function deleteSelectedItems() {
            if (confirm('선택한 상품을 삭제하시겠습니까?')) {
                var checkboxes = document.getElementsByName('selectedOrders');
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i].checked) {
                        document.getElementById('cartForm').innerHTML += '<input type="hidden" name="deleteItemId" value="' + checkboxes[i].value + '">';
                    }
                }
                document.getElementById('cartForm').submit();
            }
        }
    </script>
</body>
</html>
