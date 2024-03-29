<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/myQnAList.css">
<script type="text/javascript" src="script/order.js"></script>
<style>
/* 이전 CSS 코드는 여기에 있습니다 */

/* input 요소의 테두리를 안 보이게 함 */
input[type="text"].no-border {
	border: none;
	outline: none; /* 선택 시 나타나는 외곽선도 없애기 */
}
input[type="button"] {
    padding: 0px 0px;
    border: none;
    font-size: 20px;
    border-radius: 10px;
    width: 100px;
    height: 40px;
    margin: 20px 20px 0 20px;
    background: #b3b3ff;
    font-family: 'East Sea Dokdo', sans-serif; /* 버튼 내의 폰트도 East Sea Dokdo로 변경 */
    
}
input[type="submit"] {
    padding: 0px 0px;
    border: none;
    font-size: 20px;
    border-radius: 10px;
    width: 100px;
    height: 40px;
    margin: 20px 20px 0 20px;
    background: #b3b3ff;
    font-family: 'East Sea Dokdo', sans-serif; /* 버튼 내의 폰트도 East Sea Dokdo로 변경 */
    
}
</style>
<title>장바구니</title>
</head>
<body>
	<form action="UserServlet" method="post" id="cartForm">
		<input type="hidden" name="command" value="order_delete"> <input
			type="hidden" name="id" value="${id}">

		<div id="wrap" align="center">
			<h1>장바구니</h1>
			<table class="list">

				<tr>
					<th>구분</th>
					<th>고유번호</th>
					<th>상품이름</th>
				</tr>

				<%--      <c:forEach var="pro" items="${product }">
               <td> ${pro.pname }</td>
                
                </c:forEach>
                
                <c:forEach var="cart" items="${CartList}">
                    <tr class="record">
                         <td>
                            <input type="checkbox" name="selectedOrders" value="${cart.cart_id}">
                            <input type="text" name="selectedOrderIds" value="${cart.cart_id}" />
                        </td> 
                    </tr>
                </c:forEach> --%>

				<c:forEach var="pro" items="${product}" varStatus="loop">
					<tr class="record">
						<td><input type="checkbox" name="selectedOrders"
							value="${CartList[loop.index].cart_id}"></td>
						<td><input type="text" readonly="readonly"
							name="selectedOrderIds" value="${CartList[loop.index].cart_id}" class="no-border" />
						</td>
						<td>${pro.pname}${pro.pid } <input type="hidden" name="pid"
							value="${pro.pid }">
						</td>
					</tr>
				</c:forEach>


				



			</table>
			<input type="submit" value="상품삭제" onclick="submitForm()">
			<!--  <input
				type="button" value="상품 결제"
				onclick="location.href='UserServlet?command=order_pay1_form'"> -->
			<input type="button" value="상품 결제" onclick="redirectToOrderPay()">
		</div>
	</form>

	<script type="text/javascript">
		function submitForm() {
			if (confirmDelete()) {
				document.getElementById('cartForm').submit();
			}
		}

		/* function redirectToOrderPay() {
			var selectedOrders = [];
			var checkboxes = document.getElementsByName('selectedOrders');
			for (var i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					selectedOrders.push(checkboxes[i].value);
				}
			}
			var id = "${loginUser.id}";
			var url = "UserServlet?command=order_pay1_form&id=" + id
					+ "&selectedOrders=" + selectedOrders.join(',');
			location.href = url;
		} */
		function redirectToOrderPay() {
			var selectedOrders = [];
			var checkboxes = document.getElementsByName('selectedOrders');
			for (var i = 0; i < checkboxes.length; i++) {
				if (checkboxes[i].checked) {
					selectedOrders.push(checkboxes[i].value);
				}
			}
			var id = "${loginUser.id}";
			var url = "UserServlet?command=order_pay1_form&id=" + id
					+ "&selectedOrders=" + selectedOrders.join(',');
			location.href = url;
		}
	</script>

</body>
</html>
