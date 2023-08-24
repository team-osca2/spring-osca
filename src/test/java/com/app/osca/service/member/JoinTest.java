package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;
import com.app.osca.service.ceo.CeoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JoinTest {

    @Autowired
    MemberService memberService;

    @Autowired
    CeoService ceoService;

//    회원가입 서비스 테스트
    @Test
    public void generalJoin(){

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("카페사장15");
        memberVO.setMemberPhonenumber("01099912345");
        memberVO.setMemberPassword("okay12345");
        memberVO.setMemberEmail("okay1@namber.com");
        memberVO.setMemberRole(1L);

        memberService.join(memberVO);
    }

//   로그인 서비스 테스트
    
}
