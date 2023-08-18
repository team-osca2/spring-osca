
const emailRegex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
const email = document.querySelector('input[name="email"]');
const emailErrorMessage = document.querySelector(".email-input-area .input-error-message");
email.addEventListener("input", event => emailCheck(event.target));



const passwordRegex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,}$/;
const password = document.querySelector('input[name="password"]');
const passwordErrorMessage = document.querySelector(".password-input-area .input-error-message");
password.addEventListener("input", event => passwordCheck(event.target));



const passwordConfirm = document.querySelector('input[name="passwordConfirm"]');
const passwordConfirmErrorMessage = document.querySelector(".password-confirm-input-area .input-error-message");
passwordConfirm.addEventListener("input", event => passwordConfirmCheck(event.target));



const selectMenuList = document.querySelectorAll(".input-select-body");
const selectMenuContentsList = document.querySelectorAll(".select-menu");
selectMenuList.forEach((selectMenu, idx) => selectMenu.onclick = event => expandSelectMenu(event.target.children[0], idx));



const submitButton = document.querySelector('button[type="button"]');
submitButton.addEventListener("click", submitButtonClick);



const inputTags = document.querySelectorAll("input");
inputTags.forEach(inputTag => inputTag.addEventListener("keydown", blockEnter));



const checkItemList = [email, password, passwordConfirm];


