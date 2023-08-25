//package com.app.osca.service.member;
//
//import com.app.osca.domain.MemberVO;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//@SpringBootTest
//@Slf4j
//public class memberServiceTestYujin {
//    @Autowired
//    private MypageMemberService memberService;

//    @Test
//    public void selectTest() {
//        memberService.getMember(2L).map(MemberVO::toString).ifPresent(log::info);
//    }
//}

//    @Test
//    public void updateTest(){
//        memberService.getMember(2L).ifPresent(memberVO->{
//            memberVO.setMemberName("선희원");
////        memberVO.setMemberPhonenumber("01012341234");
//            memberService.modify(memberVO);
//        });
//    }
//
//    @Test
//    public void deleteTest(){
//        memberService.remove(22L);
//    }
//}
