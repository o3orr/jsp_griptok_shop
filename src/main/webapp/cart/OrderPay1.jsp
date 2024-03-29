<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/orderpay.css">
<title>주문 / 결제</title>
</head>
<body>
    <div id="wrap" align="center">
        <h1>주문 / 결제</h1>
        <form name="frm" method="post" id="paymentForm">
            <input type="hidden" name="command" value="order_pay1">
            <table>
                <tr style="display: none;">
                    <th>회원번호</th>
                    <td><input type="text" name="num" value="${loginUser.num}" readonly> * 필수</td>
                </tr>
                <tr>
                    <th>구매자 성명</th>
                    <td><input type="text" name="name" value="${loginUser.username}" readonly></td>
                </tr>
                <tr>
                    <th>주문 상품</th>
                    <td>${selectedOrderIds }  (배송이 시작되면 주문 취소가 불가능 합니다.)</td>
                </tr>
                <tr>
                    <th>전화번호</th>
                    <td><input type="text" name="email" value="${loginUser.phone}"></td>
                </tr>
                <tr>
                    <th>이메일</th>
                    <td><input type="text" size="70" name="title" value="${loginUser.email}" ></td>
                </tr>
                <tr>
                    <th>우편번호(주소)</th>
                    <td><input type="text" size="70" name="title" value="${loginUser.addr}" > * 필수</td>
                </tr>
                <tr>
                    <th>상세 주소</th>
                    <td><input type="text" size="70" name="title" value="${loginUser.addr2}" > * 필수</td>
                </tr>
                <tr>
                    <th>총합 가격</th>
                    <!-- 여기에 총합 가격을 표시하는 필드 추가 -->
                </tr>
                <tr>
                    <th>주문 시 요청사항</th>
                    <td><textarea cols="70" rows="15" name="content"></textarea></td>
                </tr>
            </table>
            <br> <br> 
            <input type="reset" value="이 전(장바구니)"
                onclick="location.href='ProServlet?command=cart_list&id=${loginUser.id}'">
            <input type="button" value="결제하기" id="paymentButton">
            
            <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
            <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
            <script type="text/javascript">
                $(document).ready(function() {
                    $('#paymentButton').click(function() {
                    	
                        IMP.init('imp21466554');  //imp21466554

                        // 결제 요청하기
                        IMP.request_pay({
                            pg: 'inicis',
                            pay_method: 'card',
                            merchant_uid: 'merchant_' + new Date().getTime(),
                            name: '그립톡',
                            amount: 100, 
                            buyer_email: '',
                            buyer_name: '',
                            buyer_tel: '',
                            buyer_addr: '',
                            buyer_postcode: ''
                        }, function(rsp) {
                            if (rsp.success) {
                                 b
                                 
                            } else {
                            	 var errorMessage = "결제에 실패하였습니다.";
                            	    if (rsp.error_msg) {
                            	        errorMessage += "\n에러 메시지: " + rsp.error_msg;
                            	    }
                            	    alert(errorMessage);
                            	    location.href = "ProServlet?command=order_list&id=${loginUser.id}";
                            }
                        });
                    });
                });
            </script>
        </form>
    </div>
</body>
</html>
