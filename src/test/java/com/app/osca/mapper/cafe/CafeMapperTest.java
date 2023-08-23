package com.app.osca.mapper.cafe;

import com.app.osca.domain.CafeVO;
import com.app.osca.mapper.CafeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeMapperTest {

    @Autowired
    private CafeMapper cafeMapper;

    @Test
    public void selectAllTest(){
        cafeMapper.selectAll().stream().map(CafeVO::toString).forEach(log::info);
    }
}
