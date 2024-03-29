<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
    // 삭제 버튼을 클릭한 경우에만 실행되도록 수정
    if (window.name == 'delete') {
        // 서버로부터 올바른 상품 ID가 전달되는지 확인
        console.log("상품 ID:", ${pro.pid});

        // 상품 ID가 제대로 전달되는지 확인
        if (${pro.pid} !== null && ${pro.pid} !== '') {
            // 올바른 상품 ID가 있는 경우 삭제 요청을 서버로 전송
            window.opener.parent.location.href = "ProServlet?command=pro_delete&pid=${pro.pid}";
            alert("삭제되었습니다.");
        } else {
            // 상품 ID가 올바르지 않은 경우에 대한 처리
            alert("상품 ID가 올바르지 않습니다.");
        }
    }

    // 창을 닫도록 변경
    window.close();
</script>

</body>
</html>