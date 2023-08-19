const $study = $('.study-fav');
const $cafe = $('.cafe-fav');

const $underline = $('.underline');

$study.on('click', function() {
    $study.addClass('active');
    $cafe.removeClass('active');
    $underline.removeClass('active-underline');

    $(this).closest('.underline').addClass('active-underline');
});

$cafe.on('click', function() {
    $cafe.addClass('active');
    $study.removeClass('active');
    $underline.removeClass('active-underline');

    $(this).closest('.underline').addClass('active-underline');
});


