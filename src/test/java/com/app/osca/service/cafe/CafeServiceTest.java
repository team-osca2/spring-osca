package com.app.osca.service.cafe;

import com.app.osca.domain.CafeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeServiceTest {
    @Autowired
    private CafeService cafeService;

    @Test
    public void getListTest(){
        cafeService.getList().stream().map(CafeVO::toString).forEach(log::info);
    }

}
