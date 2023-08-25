package com.app.osca.cafeAd.service;

import com.app.osca.service.cafeAd.CafeAdService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeAdServiceTest {

    @Autowired
    private CafeAdService cafeAdService;

    @Test
    public void getOneCafeAdTest(){
        cafeAdService.getOneCafeAd(2L).ifPresent(dto -> log.info(dto.toString()));
    }

}
