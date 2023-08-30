const open = (coupon) => () => {
    document.querySelector(".modal").classList.remove("hidden");
    console.log(coupon.dataset.duration, coupon.dataset.price);
}

const close = () => {
    document.querySelector(".modal").classList.add("hidden");
}

const useCoupons = document.querySelectorAll(".coupon-list-element");

useCoupons.forEach(coupon=>coupon.addEventListener("click",open(coupon)));
document.querySelector(".closeBtn").addEventListener("click", close);
document.querySelector(".cancel_button").addEventListener("click", close);
