package com.app.osca.cafe.service;

import com.app.osca.domain.CafeVO;
import com.app.osca.service.cafe.CafeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeServiceTest {

    @Autowired
    private CafeService cafeService;

    @Test
    public void getListTest(){
        cafeService.getList().stream().map(CafeVO::toString).forEach(log::info);
    }

    @Test
    public void getOneTest(){
        assertThat(cafeService.getOne(2L).orElseGet(CafeVO::new).getCafeName()).isEqualTo("카페베네");
    }

}
