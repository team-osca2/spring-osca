const $edit = $('.edit-click');
const $save = $('.save');
const $cancel = $('.cancel');
const $idInput = $('.id-input');
const $edit2 = $('.edit-click2');
const $save2 = $('.save2');
const $cancel2 = $('.cancel2');
const $idInput2 = $('.id-input2');

$edit.click(function () {
    $save.removeClass('displayNone');
    $cancel.removeClass('displayNone');
    $edit.addClass('displayNone');
    $idInput.prop('disabled', false);
    $idInput.css('background-color', '#fff');
});

$save.click(disable);
$cancel.click(disable);

function disable(){
    $save.addClass('displayNone');
    $cancel.addClass('displayNone');
    $edit.removeClass('displayNone');
    $idInput.prop('disabled', true);
    $idInput.css('background-color', '#fafafc');
}

$edit2.click(function () {
    $save2.removeClass('displayNone');
    $cancel2.removeClass('displayNone');
    $edit2.addClass('displayNone');
    $idInput2.prop('disabled', false);
    $idInput2.css('background-color', '#fff');
});

$save2.click(disable2);
$cancel2.click(disable2);

function disable2(){
    $save2.addClass('displayNone');
    $cancel2.addClass('displayNone');
    $edit2.removeClass('displayNone');
    $idInput2.prop('disabled', true);
    $idInput2.css('background-color', '#fafafc');
}


const regex2 = /[0-9]/;
const $businessNo = $('.redborder');

$businessNo.keyup(function () {
    var $this = $(this);

    if (!regex2.test($this.val()) || $this.val().length == 10) {
        $idInput2.css('border-color', '#e4e5ed')
    } else {
        $idInput2.css('border-color', 'red');
    }
});
