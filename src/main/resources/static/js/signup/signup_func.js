
// email 유효성 검사
function emailCheck(target){
    let contents = target.value;
    if(!contents.match(emailRegex)){
        emailErrorMessage.innerText = '이메일 형식이 유효하지 않습니다.';
        return false;
    }
    emailErrorMessage.innerText = '';
    return true;
}

// password 유효성 검사
function passwordCheck(target){
    let contents = target.value;
    if(!contents.match(passwordRegex)){
        passwordErrorMessage.innerText = '8자 이상, 영문 대 소문자, 숫자, 특수문자를 사용하세요.';
        return false;
    }
    passwordErrorMessage.innerText = '';
    return true;
}

// password 확인
function passwordConfirmCheck(target){
    let contents = target.value;
    let password_value = password.value;
    if(contents !== password_value){
        passwordConfirmErrorMessage.innerText = '비밀번호를 확인해 주세요.';
        return false;
    }
    passwordConfirmErrorMessage.innerText = '';
    return true;
}

// select 박스 열고 닫기
let index = 0;
function expandSelectMenu(selectMenu, idx){
    index = idx;
    let currentMenuStatus = selectMenuContentsList[index].style.display;
    if(currentMenuStatus == 'none'){
        selectMenuContentsList[index].style.display = 'block';  
        selectMenuContentsList[index].addEventListener('click', bodyClickCloseSelectMenu);
    }
    else{
        // selectMenuContentsList[index].style.display = 'none';
        selectMenuContentsList[index].removeEventListener('click', bodyClickCloseSelectMenu);
    }
}

function bodyClickCloseSelectMenu(e){
    console.log(e.target)
    if(!selectMenuList[index].contains(e.target)){
        selectMenuContentsList.forEach(selectMenuContent => selectMenuContent.style.display = 'none');
    }
}

// input태그에서 enter키 막기
function blockEnter(enter){
    if(enter.code === "Enter"){
        enter.preventDefault();
    }
}

// 버튼 클릭 이벤트
const checkFuncList = [emailCheck, passwordCheck, passwordConfirmCheck];
function submitButtonClick(e){
    checkFuncList.forEach((checkFunc, idx) => {
        let item = checkItemList[idx];
        if(!checkFunc(item)){
            item.focus();
            return;
        }
    });

    document.getElementById("signup_form").submit();
}