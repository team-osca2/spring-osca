package com.app.osca.service.member;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class findAccountTest {
    @Autowired
    MemberService memberService;

//   계정 찾기 테스트
    @Test
    public void findAccountTest(){
        String membername = "김동엽";
        String memberPhonenumber = "010765011475";
        List<String> emails = memberService.getGeneralAccounts(membername, memberPhonenumber);
        if ( emails.isEmpty() ) {
            log.info("{}.............", "가입된 계정이 없습니다.");
        } else {
            log.info("{}..................", emails.toString());
        }
    }
}
