
function confirmDelete() {
	if (confirm("정말 삭제하시겠습니까?")) {
		document.getElementById("order").submit();
	} else {
		return false; // 취소 버튼을 눌렀을 때 폼을 제출하지 않음
	}
}
