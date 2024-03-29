// user_register.js

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
    if (month < 10) month = '0' + month;
    if (day < 10) day = '0' + day;
    if (hour < 10) hour = '0' + hour;
    if (minute < 10) minute = '0' + minute;
    if (second < 10) second = '0' + second;

    // yyyy-MM-dd HH:mm:ss 형식으로 반환
    return year + '-' + month + '-' + day + ' ' + hour + ':' + minute + ':' + second;
}

// 폼이 로드될 때 현재 날짜 및 시간을 입력
window.onload = function() {
    document.getElementById('register_date').value = getCurrentDateTime();
};

// 주소 찾기 기능
function findAddr() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('member_post').value = data.zonecode;
            document.getElementById("member_addr").value = data.roadAddress || data.jibunAddress;
        }
    }).open();
}
