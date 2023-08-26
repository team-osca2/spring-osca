const open = () => {
    document.querySelector(".modal").classList.remove("hidden");
}

const close = () => {
    document.querySelector(".modal").classList.add("hidden");
}

const useCoupons = document.querySelectorAll(".coupon-list-element");

useCoupons.forEach(coupon=>coupon.addEventListener("click",open));
document.querySelector(".closeBtn").addEventListener("click", close);
document.querySelector(".cancel_button").addEventListener("click", close);
