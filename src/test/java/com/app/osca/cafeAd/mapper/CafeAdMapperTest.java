package com.app.osca.cafeAd.mapper;

import com.app.osca.mapper.CafeAdMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeAdMapperTest {

    @Autowired
    private CafeAdMapper cafeAdMapper;

    @Test
    public void selectTest(){
        assertThat(
            cafeAdMapper.select(41L).getCafeId()
        ).isEqualTo(2L);
    }

}
