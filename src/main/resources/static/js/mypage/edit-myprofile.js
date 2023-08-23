// 왼쪽 메뉴 볼드 처리~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
const $infoArea = $('.information');
const $expertArea = $('.area-of-expertise');
const $skillArea = $('.skills');
const $periodArea = $('.workperiod');
const $schoolArea = $('.school');
const $menu = $('.aside-menu');

$infoArea.on('click', function() {
    $menu.find('.selected-menu').removeClass('selected-menu');
    $menu.find('.menu-list').first().addClass('selected-menu');
});

$expertArea.on('click', function() {
    $menu.find('.selected-menu').removeClass('selected-menu');
    $menu.find('.menu-list').eq(1).addClass('selected-menu');
});

$skillArea.on('click', function() {
    $menu.find('.selected-menu').removeClass('selected-menu');
    $menu.find('.menu-list').eq(2).addClass('selected-menu');
});
$periodArea.on('click', function() {
    $menu.find('.selected-menu').removeClass('selected-menu');
    $menu.find('.menu-list').eq(3).addClass('selected-menu');
});
$schoolArea.on('click', function() {
    $menu.find('.selected-menu').removeClass('selected-menu');
    $menu.find('.menu-list').eq(4).addClass('selected-menu');
});


// 닉네임 입력 제한~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
const $nicknameInput = $('.nickname');
const $nickCount = $('.nick-count');
const maxLength = 17; // 최대 길이 설정

$nicknameInput.on('input', function() {
    const currentLength = $(this).val().length;
    $nickCount.text(`${currentLength}/${maxLength}`);

    if (currentLength > maxLength) {
        $(this).val($(this).val().substring(0, maxLength));
    }
});

const $introInput = $('.intro-text-input');
const $introCount = $('.intro-text-count');
const introMaxLength = 255; // 최대 길이 설정
// 소개 입력 제한
$introInput.on('input', function() {
    const currentIntroLength = $(this).val().length;
    $introCount.text(`${currentIntroLength}/${introMaxLength}`);

    if (currentIntroLength > introMaxLength) {
        $(this).val($(this).val().substring(0, introMaxLength));
    }
});



// 전문 분야~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
const $expertInputArea = $('.expert-in');
const $expertMenus = $('.expert-menu-container');
const $selectedExpert = $('.expert-option-selected');

$expertInputArea.on('click', function() {
    $expertMenus.toggle();
});


const $expertText = $('.expert-option');
const $expertTextSelected = $('.expert-option-selected');
const $expertTick = $('.expert-tick ');
const $expertTickSelected = $('.expert-tick-selected');

$expertText.on('click', function() {
    // 해당 엘리먼트의 클래스 토글
    $(this).toggleClass('expert-option-selected');
    // 틱 아이콘도 토글
    $(this).find('.expert-tick').toggleClass('expert-tick-selected');
});

// 저장할 변수 초기화
const selectedExpertises = [];

const $selectedExpertList = $('.selected-expertise-list');
$('.expert-text').on('click', function() {
    const selectedExpText = $(this).text(); // Remove unnecessary .find('.expert-text')

    // 이미 선택되었는지 확인
    const isAlreadySelected = selectedExpertises.includes(selectedExpText);

    if (isAlreadySelected) {
        // 이미 선택된 경우 선택 취소
        const index = selectedExpertises.indexOf(selectedExpText);
        $(`.selected-expertise-name:contains("${selectedExpText}")`).parent().remove();
        if (index > -1) {
            selectedExpertises.splice(index, 1);
        }
    } else {
        // 선택되지 않은 경우 선택 추가
        selectedExpertises.push(selectedExpText);

        // 새로운 선택된 전문 분야 엘리먼트 생성
        const selectedExpertiseElement = `
      <div class="selected-expertise">
        <div shape="rounded" label="delete" class="selected-expertise-name">
          ${selectedExpText}
          <div class="button-x">
            <span role="img" color="#c8cad2" rotate="0" class="span-x">
              <svg width="17" height="17" viewBox="0 0 24 24" fill="currentColor" focusable="false" preserveAspectRatio="xMidYMid meet" class="svg-x">
                <path xmlns="http://www.w3.org/2000/svg" d="M6.34314575,4.92893219 L12.000039,10.585039 L17.6568542,4.92893219 C18.0473785,4.5384079 18.6805435,4.5384079 19.0710678,4.92893219 C19.4615921,5.31945648 19.4615921,5.95262146 19.0710678,6.34314575 L13.415039,12.000039 L19.0710678,17.6568542 C19.4615921,18.0473785 19.4615921,18.6805435 19.0710678,19.0710678 C18.6805435,19.4615921 18.0473785,19.4615921 17.6568542,19.0710678 L12.000039,13.415039 L6.34314575,19.0710678 C5.95262146,19.4615921 5.31945648,19.4615921 4.92893219,19.0710678 C4.5384079,18.6805435 4.5384079,18.0473785 4.92893219,17.6568542 L10.585039,12.000039 L4.92893219,6.34314575 C4.5384079,5.95262146 4.5384079,5.31945648 4.92893219,4.92893219 C5.31945648,4.5384079 5.95262146,4.5384079 6.34314575,4.92893219 Z"></path>
              </svg>
            </span>
          </div>
        </div>
      </div>
    `;

        // 생성한 엘리먼트를 .selected-expertise-list에 추가

        $selectedExpertList.append(selectedExpertiseElement);
    }
});

// 다시 눌렀을때 개별 삭제
$selectedExpertList.on('click', '.selected-expertise-name', function() {
    const selectedExpText = $(this).text().trim();
    const index = selectedExpertises.indexOf(selectedExpText);


    const $relatedExpertOption = $(`.expert-text:contains("${selectedExpText}")`);
    $relatedExpertOption.closest('.expert-option').removeClass('expert-option-selected');
    $relatedExpertOption.find('.expert-tick').removeClass('expert-tick-selected');

    if (index > -1) {
        selectedExpertises.splice(index, 1);
    }

    $(this).closest('.selected-expertise').remove();
});

// 전체 삭제 버튼 클릭 처리
$('.delete-button').on('click', function() {
    selectedExpertises.length = 0; // 어레이 클리어
    $selectedExpertList.empty(); // 클라스 안에 버튼들 제거

    // 노란색 제거
    $('.expert-option').removeClass('expert-option-selected');
    $('.expert-tick').removeClass('expert-tick-selected');
});



// 보윺 기술~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//  skill-name-list 클릭 
const $skillNameArea = $('.skill-name-list');
const $skillsBox =  $('.skills-selected-box')
$skillNameArea.on('click', function() {
    $(this).toggleClass('selected-skill');

    if ($(this).hasClass('selected-skill')) {
        const skillName = $(this).find('.skill-name').text();
        const selectedSkillElement = `
      <div class="skills-each">
        <div shape="rounded" label="delete" class="selected-skills-name">
          ${skillName}<div type="button" class="button-x">
            <span role="img" color="#c8cad2" rotate="0" class="span-x">
              <svg width="17" height="17" viewBox="0 0 24 24" fill="currentColor" focusable="false" preserveAspectRatio="xMidYMid meet" class="svg-x">
                <path xmlns="http://www.w3.org/2000/svg" d="M6.34314575,4.92893219 L12.000039,10.585039 L17.6568542,4.92893219 C18.0473785,4.5384079 18.6805435,4.5384079 19.0710678,4.92893219 C19.4615921,5.31945648 19.4615921,5.95262146 19.0710678,6.34314575 L13.415039,12.000039 L19.0710678,17.6568542 C19.4615921,18.0473785 19.4615921,18.6805435 19.0710678,19.0710678 C18.6805435,19.4615921 18.0473785,19.4615921 17.6568542,19.0710678 L12.000039,13.415039 L6.34314575,19.0710678 C5.95262146,19.4615921 5.31945648,19.4615921 4.92893219,19.0710678 C4.5384079,18.6805435 4.5384079,18.0473785 4.92893219,17.6568542 L10.585039,12.000039 L4.92893219,6.34314575 C4.5384079,5.95262146 4.5384079,5.31945648 4.92893219,4.92893219 C5.31945648,4.5384079 5.95262146,4.5384079 6.34314575,4.92893219 Z"></path>
              </svg>
            </span>
          </div>
        </div>
      </div>
    `;
        $skillsBox.append(selectedSkillElement);
    } else {
        const skillName = $(this).find('.skill-name').text();
        $('.selected-skills-name').filter(function() {
            return $(this).text().trim() === skillName;
        }).parent().remove();
    }

});


// 개별 스킬 삭제 버튼 클릭

$('.skills-selected-box').on('click', '.button-x', function() {
    const $xButton = $(this);
    const $selectedSkillsName = $xButton.closest('.selected-skills-name');
    const skillNameText = $selectedSkillsName.text().trim();
    $(this).closest('.skills-each').remove();

    $('.skill-name').each(function() {
        if ($(this).text().trim() === skillNameText) {
            $(this).closest('.selected-skill').removeClass('selected-skill');
        }
    });

});

// 전체 삭제 버튼 클릭
$('.delete-button2').on('click', function() {
    $('.selected-skill').removeClass('selected-skill');
    $('.skills-each').remove();
});


// 경력기간 입력칸~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
const $periodInput = $('.workperiod-input-area');
const $periodMenus = $('.workperiod-menu-container');
const $periodText = $('.workperiod-option');
const $Selectedperiod = $('.workperiod-option-selected');
const $periodList = $('.workperiod-list');
$periodInput.on('click', function() {
    $periodMenus.css('display','block');

});

$periodText.on('click', function() {

    $('.period-holder').text('');
    // 모든 지역에서 클래스 초기화
    $periodList.children().addClass('workperiod-option').removeClass('workperiod-option-selected');
    // 클릭된 지역에 클래스 추가
    $(this).addClass('workperiod-option-selected').removeClass('workperiod-option');

    $periodMenus.css('display','none');
    const selectedPeriText = $(this).find('.workperiod-text').text();
    $('.workperiod-singleValue').text(selectedPeriText);

});