// phonenumber
const telRegex = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
const $phoneNumber = $("#tel");
const phoneNumberErrorMessage = '올바른 전화번호를 입력해 주세요.';
const $verificationbtn = $("#verificationbtn");

$phoneNumber.keyup(function(){

    if ( telRegex.test($(this).val()) ) {
        $verificationbtn.attr("disabled", false);
    } else {
        $verificationbtn.attr("disabled", true);
    }
});

$verificationbtn.click(function() {
    $.ajax({
        type: "POST",
        url: "/signUp/check-tel",
        data: `phonenumber=${$phoneNumber.val()}`,
        dataType: "text",
        success: function(data){
            console.log(data);
        },
        error: function(xhr, status, error){
            console.log(xhr, status, error);
        }
    });
});

