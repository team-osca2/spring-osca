//package com.app.osca.mapper;
//
//import com.app.osca.domain.*;
//import com.app.osca.domain.dto.*;
//;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class MapperTestsYujin {
//    @Autowired
//    private MemberMapper memberMapper;
//
//    @Autowired
//    private GeneralMapper generalMapper;
//
//    @Autowired
//    private StudyScrapMapper studyScrapMapper;
//
//    @Autowired
//    private CafeScrapMapper cafeScrapMapper;
//
//    @Autowired
//    private MemberSkillMapper memberSkillMapper;
//
//    //  멤버 테스트
//    @Test
//    public void memberSelectTest(){
//        memberMapper.selectById(1L).map(MemberVO::toString).ifPresent(log::info);
//    }
//
//    @Test
//    public void memberUpdateTest(){
//        memberMapper.selectById(1L).ifPresent(member -> {
//            member.setMemberName("정유진");
//            member.setMemberEmail("dbwls89173@gmail.com");
//            memberMapper.update(member);
//        });
//    }
//
//    @Test
//    public void memberDeleteTest(){
//        memberMapper.delete(1L);
//    }
//
////    일반 회원 테스트
//    @Test
//    public void generalInsertTest(){
//        GeneralVO generalVO = new GeneralVO();
//        generalVO.setMemberId(2L);
//        generalVO.setGeneralUniversity("대학교");
//        generalVO.setGeneralCompany("회사");
//        generalVO.setGeneralIntroduction("안녕하세요. 정유진입니다.");
//        generalVO.setGeneralCareer("개발자");
//        generalVO.setGeneralSalary("1000만원 이상");
//        generalMapper.insert(generalVO);
//    }
//
//    @Test
//    public void generalSelectTest(){
//        generalMapper.selectById(2L).map(GeneralVO::toString).ifPresent(log::info);
//    }
//
//    @Test
//    public void generalUpdateTest(){
//        generalMapper.selectById(2L).ifPresent(generalVO -> {
//            generalVO.setGeneralUniversity("한국대학교");
//            generalVO.setGeneralCompany("코리아IT아카데미");
//            generalVO.setGeneralIntroduction("안녕하세요. 개발자 정유진입니다.");
//            generalVO.setGeneralCareer("개발자");
//            generalVO.setGeneralSalary("1000만원");
//            generalMapper.update(generalVO);
//        });
//    }
//
////    스터디 스크랩 테스트
//    @Test
//    public void selectStudyScrapTest(){
//        studyScrapMapper.selectByMemberId(2L).stream().map(StudyScrapDTO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void deleteStudyScrapTest(){
//        studyScrapMapper.delete(1L);
//    }
//
////    카페 스크랩 테스트
//    @Test
//    public void selectCafeScrapTest(){
//        cafeScrapMapper.selectByMemberId(2L).stream().map(CafeScrapDTO::toString).forEach(log::info);
//    }
//
//    @Test
//    public void deleteCafeScrapTest(){
//        cafeScrapMapper.delete(1L);
//    }
//
////    스터디 스킬 등록 테스트
//    @Test
//    public void insertMemberSkillTest() {
//        MemberSkillVO memberSkillVO = new MemberSkillVO();
//        memberSkillVO.setMemberId(3L);
//        memberSkillVO.setSkillListId(2L);
//        memberSkillMapper.insert(memberSkillVO);
//    }
//
//    @Test
//    public void selectMemberSkillTest(){
//        memberSkillMapper.selectAllByMemberId(3L).stream().map(MemberSkillDTO::toString).forEach(log::info);
//    }
//
//}
//
