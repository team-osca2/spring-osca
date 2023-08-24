package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class JoinTest {

    @Autowired
    MemberService memberService;

//    회원가입 서비스 테스트
    @Test
    public void generalJoin(){

        MemberVO memberVO = new MemberVO();
        memberVO.setMemberName("sdsd");
        memberVO.setMemberPhonenumber("01088884567");
        memberVO.setMemberPassword("1234");
        memberVO.setMemberEmail("acvadaSFDav@namber.com");
        memberVO.setMemberRole(1L);

        memberService.join(memberVO);
    }

//   로그인 서비스 테스트
    
}
