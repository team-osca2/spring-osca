package com.app.osca.cafe.mapper;

import com.app.osca.domain.CafeVO;
import com.app.osca.mapper.CafeMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeMapperTest {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Autowired
    private CafeMapper cafeMapper;

    @Test
    public void selectAllTest(){
        cafeMapper.selectAll().stream().map(CafeVO::toString).forEach(log::info);
    }

    @Test
    public void selectTest() {
        assertThat(cafeMapper.select(2L).getCafeName()).isEqualTo("카페베네");
    }
}
