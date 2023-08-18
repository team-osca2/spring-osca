
const changeArea = document.querySelectorAll('.change-area'),
      findType = document.querySelector('.move-area'),
      x_size = document.querySelector('.find-account-contents').offsetWidth,
      findTypeCheckBox = document.querySelector('.find-account-main-container>section');

changeArea.forEach((change, idx) => change.addEventListener('click', () => {
    if(idx == 0){
        findType.style.transform = `translateX(0)`;
        findTypeCheckBox.classList.replace('find-type-area2', 'find-type-area');
    }else{
        findType.style.transform = `translateX(-${x_size}px)`;
        findTypeCheckBox.classList.replace('find-type-area', 'find-type-area2');
    }
}));


const nameInput = document.querySelector('#name'),
      phoneNumberInput = document.querySelector('#phoneNumber'),
      emailInput = document.querySelector('#email'),

      findIdBtn = document.querySelector('#find-id'),
      findPasswordBtn = document.querySelector('#find-password'),

      idForm = document.querySelector('#id-form'),
      passwordForm = document.querySelector('#password-form'),

      emailRegex = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i,
      phoneNumberRegex = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;

const checkPhoneNumber = () => phoneNumberRegex.test(phoneNumberInput.value),

      checkName = () => nameInput.value.trim() != '',

      checkEmail = () => emailRegex.test(emailInput.value),

      changeBtnState = (obj, state) => obj.disabled = state,

      inputStateFunc = (callback) => (btn, state1, state2 = () => true) => (e) => callback(btn, !(state1() && state2()));


nameInput.addEventListener('input', inputStateFunc(changeBtnState)(findIdBtn, checkName, checkPhoneNumber));
phoneNumberInput.addEventListener('input', inputStateFunc(changeBtnState)(findIdBtn, checkPhoneNumber, checkName));
emailInput.addEventListener('input', inputStateFunc(changeBtnState)(findPasswordBtn, checkEmail));


