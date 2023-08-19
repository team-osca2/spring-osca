const $edit = $('.sujung');
const $save = $('.save');
const $cancel = $('.cancel');
const $idInput = $('.id-input');

$edit.click(function() {
    $save.removeClass('displayNone');
    $cancel.removeClass('displayNone');
    $edit.addClass('displayNone');
    $idInput.prop('disabled', false);
    $idInput.css('background-color', '#fff'); // 따옴표로 감싸기
});
  
  $save.click(function() {
    $save.addClass('displayNone');
    $cancel.addClass('displayNone');
    $edit.removeClass('displayNone');
    $idInput.prop('disabled', true);
    $idInput.css('background-color', '#fafafc');
  });
  
  $cancel.click(function() {
    $save.addClass('displayNone');
    $cancel.addClass('displayNone');
    $edit.removeClass('displayNone');
    $idInput.prop('disabled', true);
    $idInput.css('background-color', '#fafafc');
  });
