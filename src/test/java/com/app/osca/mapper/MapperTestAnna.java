//package com.app.osca.mapper;
//
//import com.app.osca.domain.MemberVO;
//import com.app.osca.domain.dto.AdminCafeAdDTO;
//import com.app.osca.domain.dto.AdminPaymentDTO;
//import com.app.osca.domain.dto.AdminStudyDTO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.List;
//
//@SpringBootTest
//@Slf4j
//public class MapperTestAnna {
//    @Autowired
//    private AdminStudyMapper adminStudyMapper;
//    @Autowired
//    private AdminCafeAdMapper adminCafeAdMapper;
//    @Autowired
//    private AdminMemberMapper adminMemberMapper;
//    @Autowired
//    private AdminPaymentMapper adminPaymentMapper;
//
//    @Test
//    public void selectAllStudyTest(){
////        adminStudyMapper.selectAllStudy().stream().map(AdminStudyDTO::toString).forEach(log::info);
//    }
////    @Test
////    public void selectAllPostTest(){
////        studyMapper.selectAllPost().stream().map(StudyDTO::toString).forEach(log::info);
////    }
//
//    @Test
//    public void selectAllCafePost(){
//        adminCafeAdMapper.selectAllCafePost().stream().map(AdminCafeAdDTO::toString).forEach(log::info);
//    }
//
//    //    관리자 전체 유저 목록
//    @Test
//    public void selectAllTest(){
//        adminMemberMapper.selectAll().stream().map(MemberVO::toString).forEach(log::info);
//    }
//    @Test
//    //   <!-- 관리자 일반 유저 목록-->
//    public void selectAllUserSTest(){
//        adminMemberMapper.selectAllUserS().stream().map(MemberVO::toString).forEach(log::info);
//    }
//    @Test
//    //    <!-- 관리자 카페 유저 목록-->
//    public void selectAllUserCTest(){
//        adminMemberMapper.selectAllUserC().stream().map(MemberVO::toString).forEach(log::info);
//    }
//    @Test
//    //    <!-- 관리자 신고당한 유저 목록-->
//    public void selectUserReportedTest(){
//        adminMemberMapper.selectUserReported().stream().map(MemberVO::toString).forEach(log::info);
//    }
//    @Test
//    //    <!-- 관리자 정지당한 유저 목록-->
//    public void selectUserBlockedTest(){
//        adminMemberMapper.selectUserBlocked().stream().map(MemberVO::toString).forEach(log::info);
//    }
//    @Test
//    //    <!-- 관리자 유저 정지 시키기 o-->
//    public void updateStateBlockTest(){
//        adminMemberMapper.updateStateBlock(122L);
//    }
//    @Test
//    //    <!-- 관리자 유저 복구-->
//    public void updateStateUnblockTest(){
//        adminMemberMapper.updateStateUnblock(122L);
//    }
//    @Test
//    //<!--    관리자 카페 글 블락-->
//    public void updateCafeBlockTest(){
//        adminCafeAdMapper.updateCafeBlock(2L);
//    }
//
//    @Test
//    //<!--    관리자 카페 글 복구-->
//    public void updateCafeUnblockTest(){
//        adminCafeAdMapper.updateCafeUnblock(2L);
//    }
//
//    @Test
//    //    <!--    관리자 스터디 글 블락-->
//    public void updateStudyBlockTest(){
//        adminStudyMapper.updateStudyBlock(2L);
//    }
//
//    @Test
//    //    <!--    관리자 카페 글 복구-->
//    public void updateStudyUnblockTest(){
//        adminStudyMapper.updateStudyUnblock(2L);
//    }
//
//    @Test
////    관리자 결제 내역 보기
//    public void selectAll(){
//        adminPaymentMapper.selectAll().stream().map(AdminPaymentDTO::toString).forEach(log::info);
//    }
//
//}
