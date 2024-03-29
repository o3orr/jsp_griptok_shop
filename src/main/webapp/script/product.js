function open_win(url, name) {
	window.open(url, name, "width=1000, height=500");
}
function confirmDelete(pid) {
	var result = confirm("정말로 이 상품을 삭제하시겠습니까?");
	if (result) {
		// 확인을 눌렀을 때만 삭제 요청 보내기
		window.location.href = 'ProServlet?command=pro_delete&pid=' + pid;
	} else {
		// 취소했을 경우
		alert("삭제가 취소되었습니다.");
	}
}
function editProduct(pid) {
	window.location.href = 'ProServlet?command=pro_update_form&pid=' + pid;
}



function addcart() {
	// 장바구니 버튼을 클릭했을 때의 동작
	// 여기에서는 장바구니 JSP로 이동하는 예시 코드입니다.
	window.location.href = 'ProServlet?command=order_pay1_form'; // 여기에 실제 장바구니 JSP의 URL을 입력하세요.
}
/*function addcart() {
	// 장바구니 버튼을 클릭했을 때의 동작
	// 여기에서는 장바구니 JSP로 이동하는 예시 코드입니다.
	window.location.href = 'ProServlet?command=order_pay1_form'; // 여기에 실제 장바구니 JSP의 URL을 입력하세요.
}*/