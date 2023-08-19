const $wrongText1 = $('.p1');
const $wrongText2 = $('.p2');
const $wrongText3 = $('.p3');

const $newPW = $('[name="newPassword"]');
const $newPW2 = $('[name="newConfirmPassword"]');

$newPW.keyup(function() {
    const regex = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[!@#$%^&*()]).{8,}$/;
    let $this = $(this);

    if (!regex.test($this.val()) || $this.val().length < 8) {
        $wrongText2.css('display', 'block');
    } else {
        $wrongText2.css('display', 'none');
    }
});

$newPW2.keyup(function() {
    const newPassword = $newPW.val();

    if ($newPW2.val() !== newPassword) {
        $wrongText3.css('display', 'block');
    } else {
        $wrongText3.css('display', 'none');
    }
});

const $modal = $('.modal');
const $confirm = $('.confirm-button');
const $ok = $('.accept-btn') ;

$confirm.on('click', function() {
    event.preventDefault();
    $modal.removeClass('hidden');

    setTimeout(function() {
        $modal.addClass('hidden');
    }, 3000); 
});


$ok.on('click', function() {
    $modal.addClass('hidden');
});
