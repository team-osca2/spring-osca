package com.app.osca.service.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class kakaoTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private KakaoService kakaoService;

//    @Test
//    public void kakaoLoginTest(){
//        String memberId = "kakaoooo@daum.net";
//        if ( !memberService.checkId(memberId).isPresent() ) {
//            memberService.joinKakaoMember(memberId);
//        } else {
//            log.info("{계정이 존재함}................");
//        }
//
//    }
}
