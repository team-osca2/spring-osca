package com.app.osca.mapper.cafeAd;

import com.app.osca.mapper.CafeAdMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeAdMapperTest {

    @Autowired
    private CafeAdMapper cafeAdMapper;

    @Test
    public void selectTest(){
        cafeAdMapper.select(4L).ifPresent(dto -> log.info(dto.toString()));
    }

}
