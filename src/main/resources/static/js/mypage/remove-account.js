const $radiolist = $('.list-label');
$radiolist.on('click', function() {
    const radioInner = $(this).find('.radio__inner');
    
    $('.radio__inner.selected').removeClass('selected');

    radioInner.addClass('selected');
    
    const radioInput = $(this).find('.radio__input');
    radioInput.prop('checked', true);


    const $self = $('.self-input');
    if ($radiolist.last().is(this)) {
        $self.removeClass('displayNone');
    } else {
        $self.addClass('displayNone');
    }
});


const $checkClick = $('.check-wrapper');
const $checked = $('.checkbox__inner');
const $finalButton = $('.final-button');
$checkClick.on('click', function() {
    $checked.toggleClass('check-selected');
    
    if ($checked.hasClass('check-selected')) {
        $finalButton.prop('disabled', false);
    } else {
        $finalButton.prop('disabled', true);
    }
});
