package com.app.osca.mapper;

import com.app.osca.domain.*;
import com.app.osca.domain.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

;

@SpringBootTest
@Slf4j
public class MapperTestsYujin {
    @Autowired
    private MypageMemberMapper memberMapper;

    @Autowired
    private MypageGeneralMapper generalMapper;

    @Autowired
    private MypageStudyScrapMapper studyScrapMapper;

    @Autowired
    private MypageCafeScrapMapper cafeScrapMapper;

    @Autowired
    private MypageMemberSkillMapper memberSkillMapper;

    @Autowired
    private MypagePaymentMapper paymentMapper;

    //  멤버 테스트
    @Test
    public void memberSelectTest(){
        memberMapper.selectById(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void memberNicknameSelectTest(){
        memberMapper.selectNickname("사과42");
    }

    @Test
    public void memberUpdateTest(){
        memberMapper.update("돈많은 개발자",1L);
    }

    @Test
    public void memberDeleteTest(){
        memberMapper.delete(1L);
    }

    //  비밀번호 변경 테스트
    @Test
    public void memberPasswordInsertTest(){
        log.info(memberMapper.selectPassword(1L));
    }

    @Test
    public void memberPasswordUpdateTest() {
        String password = "@dbwls1234";
        String encryptedPassword = "";
        final int KEY = 3;
        for (int i = 0; i < password.length(); i++) {
            encryptedPassword += (char)(password.charAt(i) * KEY);
        }
        memberMapper.updatePassword(encryptedPassword, 1L);
    }

    //    일반 회원 테스트
    @Test
    public void generalInsertTest(){
        GeneralVO generalVO = new GeneralVO();
        generalVO.setMemberId(2L);
        generalVO.setGeneralUniversity("대학교");
        generalVO.setGeneralCompany("회사");
        generalVO.setGeneralIntroduction("안녕하세요. 정유진입니다.");
        generalVO.setGeneralCareer("개발자");
        generalVO.setGeneralSalary("1000만원 이상");
        generalMapper.insert(generalVO);
    }

    @Test
    public void generalSelectTest(){
        generalMapper.selectById(2L).map(GeneralVO::toString).ifPresent(log::info);
    }

    @Test
    public void generalUpdateTest(){
        generalMapper.selectById(2L).ifPresent(generalVO -> {
            generalVO.setGeneralUniversity("한국대학교");
            generalVO.setGeneralCompany("코리아IT아카데미");
            generalVO.setGeneralIntroduction("안녕하세요. 개발자 정유진입니다.");
            generalVO.setGeneralCareer("개발자");
            generalVO.setGeneralSalary("1000만원");
            generalMapper.update(generalVO);
        });
    }

    //    스터디 스크랩 테스트
    @Test
    public void selectStudyScrapTest(){
        studyScrapMapper.selectByMemberId(1L).stream().map(StudyScrapDTO::toString).forEach(log::info);
    }

    @Test
    public void deleteStudyScrapTest(){
        studyScrapMapper.delete(1L);
    }

    //    카페 스크랩 테스트
    @Test
    public void selectCafeScrapTest(){
        cafeScrapMapper.selectByMemberId(2L).stream().map(CafeScrapDTO::toString).forEach(log::info);
    }

    @Test
    public void deleteCafeScrapTest(){
        cafeScrapMapper.delete(1L);
    }

    //    스터디 스킬 등록 테스트
//    @Test
//    public void insertMemberSkillTest() {
//        MemberSkillVO memberSkillVO = new MemberSkillVO();
//        memberSkillVO.setMemberId(3L);
//        memberSkillVO.setSkillListId(2L);
//        memberSkillMapper.insert(memberSkillVO);
//    }


//    @Test
//    public void insertAllTest() {
//        MypageMemberSkillDTO mypageMemberSkillDTO = new MypageMemberSkillDTO();
//        mypageMemberSkillDTO.setMemberId(193L);
//
//        List<Long> skillListIds = new ArrayList<>();
////        skillListIds.add(1L);
//        skillListIds.add(2L);
//        skillListIds.add(3L);
//        mypageMemberSkillDTO.setSkillListIds(skillListIds);
//
//        mypageMemberSkillMapper.insertAll(mypageMemberSkillDTO);
//    }

//        MemberSkillDTO memberSkillDTO = new MemberSkillDTO();
//        memberSkillDTO.setMemberId(193L);
//
//        List<Long> skillListIds = new ArrayList<>();
//        skillListIds.add(1L);
//        skillListIds.add(2L);
//        skillListIds.add(3L);
//        memberSkillDTO.setSkillListIds(skillListIds);
//
//        memberSkillMapper.insertAll(memberSkillDTO);


    @Test
    public void selectMemberSkillTest(){
        memberSkillMapper.selectAllByMemberId(3L).stream().map(MemberSkillDTO::toString).forEach(log::info);
    }

    //    결제 정보 추가하기 테스트
    @Test
    public void insertPaymentTest() {
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setMemberId(2L);
        paymentVO.setPaymentPrice("100000");
        paymentVO.setPaymentStatus(0L);
        paymentMapper.insert(paymentVO);
    }

    @Test
    public void selectMemberSkillExistTest(){
        memberSkillMapper.selectExistsSkill(3L, 193L);
    }
}

