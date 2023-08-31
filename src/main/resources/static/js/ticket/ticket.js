const modalTitle = document.querySelector('.modal_title_text'),
    balance = document.querySelector('#balance'),
    price = document.querySelector('#price'),
    balanceAfterPayment = document.querySelector('#balance_after_payment'),
    form = document.getElementById('modal_form'),
    submitBtn = document.querySelector('button[type=submit]');

let couponDuration = null, couponPrice = null, couponId = null, afterPayment = null;

const open = (coupon) => () => {
    document.querySelector(".modal").classList.remove("hidden");
    couponDuration = coupon.dataset.duration;
    couponPrice = coupon.dataset.price;
    couponId = coupon.dataset.id;
    afterPayment = ceoBalance - couponPrice;

    modalTitle.innerText = `${couponDuration}일 홍보권 구매`;
    balance.innerText = `${numberParsing(ceoBalance)}`;
    price.innerText = `${numberParsing(couponPrice)}`;

    if(afterPayment < 0){
        balanceAfterPayment.classList.remove('positive');
        balanceAfterPayment.classList.add('negative');
        balanceAfterPayment.innerText = `${numberParsing(-afterPayment)}`;
    }
    else{
        balanceAfterPayment.classList.remove('negative');
        balanceAfterPayment.classList.add('positive');
        balanceAfterPayment.innerText = `${numberParsing(afterPayment)}`;
    }
}

const close = () => {
    document.querySelector(".modal").classList.add("hidden");
}

const useCoupons = document.querySelectorAll(".coupon-list-element");

useCoupons.forEach(coupon=>coupon.addEventListener("click",open(coupon)));

document.querySelector(".closeBtn").addEventListener("click", close);

document.querySelector(".cancel_button").addEventListener("click", close);

const makeInfoModal = (modal, borderColor, modalIcon, modalTitle, modalFoot) =>{

    document.querySelector('.info-modal-area').style.height = getComputedStyle(document.querySelector('.modalBox')).height;

    const infoModalBox = document.querySelector('.info-modal-icon-box'),
        infoModalBody = document.querySelector('.info-modal-icon-body'),
        infoModalTitle = document.querySelector('.info-modal-title'),
        infoModalFoot = document.querySelector('.info-modal-foot>div');

    infoModalBox.style.borderColor = borderColor;
    infoModalBody.innerHTML = modalIcon;
    infoModalTitle.innerText = modalTitle;
    infoModalFoot.innerText = modalFoot;
    modal.style.display = 'flex';
}

submitBtn.addEventListener("click", () => {
    const infoModal = document.querySelector('.info-modal');
    let action = `/cafe/ticket-purchase?cafeAdId=${cafeAdId}&ticketDuration=${couponDuration}&ticketPoint=${couponPrice}`,
        method = "POST";
    makeInfoModal(infoModal, 'blue', '<span class="info-modal-icon-left-v2"></span><span class="info-modal-icon-right-v2"></span>', '결제가 완료 되었습니다.', '');

    if((!couponDuration || !couponPrice || afterPayment === null) || afterPayment < 0){
        makeInfoModal(infoModal, '#f27474', '<span class="info-modal-icon-left"></span><span class="info-modal-icon-right"></span>', '잔액이 부족합니다.', '포인트를 충전 하세요');
        action = '/mypage/point-charge';
        method = "GET";
    }
    setTimeout(() => {
        infoModal.style.display = 'none';
        form.action = action;
        form.method = method;
        form.submit();
    }, 1500);
})


