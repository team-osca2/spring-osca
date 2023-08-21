package com.app.osca.mapper;

import com.app.osca.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MapperTests {
    @Autowired
    private MemberMapper memberMapper;

    //  멤버 테스트
    @Test
    public void memberSelectTest(){
        memberMapper.select(1L).map(MemberVO::toString).ifPresent(log::info);
    }

    @Test
    public void memberUpdateTest(){
        memberMapper.select(1L).ifPresent(member -> {
            member.setMemberName("정유진");
            member.setMemberEmail("dbwls89173@gmail.com");
            memberMapper.update(member);
        });
    }

    @Test
    public void memberDeleteTest(){
        memberMapper.delete(1L);
    }
}

