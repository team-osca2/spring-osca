const $loginFrom = $("#login-form");
const $islogin = $(".logined");

console.log($islogin.val());

if ( $islogin.val().length > 0) {
    alert("로그인을 실패했습니다.");
}