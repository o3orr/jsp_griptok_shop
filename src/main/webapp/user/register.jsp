<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
   // 현재 날짜 및 시간을 가져오는 함수
   function getCurrentDateTime() {
      var now = new Date();
      var year = now.getFullYear();
      var month = now.getMonth() + 1; // 월은 0부터 시작하므로 1을 더해줍니다.
      var day = now.getDate();
      var hour = now.getHours();
      var minute = now.getMinutes();
      var second = now.getSeconds();

      // 두 자리수로 포맷팅
      if (month < 10)
         month = '0' + month;
      if (day < 10)
         day = '0' + day;
      if (hour < 10)
         hour = '0' + hour;
      if (minute < 10)
         minute = '0' + minute;
      if (second < 10)
         second = '0' + second;

      // yyyy-MM-dd HH:mm:ss 형식으로 반환
      return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':'
            + second;
   }

   // 폼이 로드될 때 현재 날짜 및 시간을 입력
   window.onload = function() {
      document.getElementById('register_date').value = getCurrentDateTime();
   };

   // 주소 검색 함수
   function findAddress() {
      new daum.Postcode({
         oncomplete : function(data) {
            document.getElementById('postcode').value = data.zonecode;
            document.getElementById('address').value = data.address;
         }
      }).open();
   }
</script>
<link rel="stylesheet" type="text/css"href="css/register.css">
<title>회원가입</title>
</head>
<body>
   <div class="register">
      <h2>회원가입을 위해 정보를 입력해주세요.</h2>
      <form name="frm" method="post" action="UserServlet">
         <input type="hidden" name="command" value="register">
         <div class="field">
            <label for="id">* 아이디</label>
            <input type="text" id="id" name="id">
         </div>
         <div class="field">
            <label for="username">이름</label>
            <input type="text" id="username" name="username">
         </div>
         <div class="field">
            <label for="phone">전화번호</label>
            <input type="text" id="phone" name="phone">
         </div>
         <div class="field">
            <label for="email">이메일</label>
            <input type="text" id="email" name="email">
         </div>
         <div class="field">
            <label for="pass">* 비밀번호</label>
            <input type="password" id="pass" name="pass">
         </div>
         <div class="field">
            <label for="postcode">우편번호</label>
            <div class="postcode">
               <input type="text" id="postcode" name="postcode" readonly width="200px">
               <input type="button" value="우편번호 검색" onclick="findAddress()">
            </div>
         </div>
         <div class="field">
            <label for="address">주소</label>
            <input type="text" id="address" name="address" readonly>
         </div>
         <div class="field">
            <label for="addr2">상세주소</label>
            <input type="text" id="addr2" name="addr2"><br><br>
         </div>
         <div class="field" style="display: none;">
            <label for="register_date">가입일</label>
            <input type="text" id="register_date" name="register_date" readonly>
         </div>
         <div class="field" style="display: none;">
            <label for="is_admin">관리자 여부</label>
            <select name="is_admin">
               <option value="N">일반 회원</option>
               <option value="Y">관리자</option>
            </select><br><br>
         </div>
         <div class="field">
            <input type="submit" value="가입">
            <input type="reset" value="다시 작성">
            <input type="button" value="목록" onclick="location.href='ProServlet?command=pro_list'">
         </div>
      </form>
   </div>
</body>
</html>