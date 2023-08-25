package com.app.osca.service.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class resetPasswordTest {

    @Autowired
    MemberService memberService;

//    비밀번호 재설정 테스트
    @Test
    public void MemberresetPasswordTest(){
        String memberPassword = "akjfndaskbfgnsdkh";
        String memberEmail = "DONGYEOP@NAVER.COM";
        memberService.setGeneralAccountPassword(memberPassword, memberEmail);
    }
}
