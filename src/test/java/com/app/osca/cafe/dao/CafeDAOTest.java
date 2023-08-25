package com.app.osca.cafe.dao;

import com.app.osca.dao.CafeDAO;
import com.app.osca.domain.CafeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeDAOTest {

    @Autowired
    private CafeDAO cafeDAO;

    @Test
    public void findAllTest(){
        cafeDAO.findAll().stream().map(CafeVO::toString).forEach(log::info);
    }

    @Test
    public void findByIdTest(){
        assertThat(cafeDAO.findById(2L).orElseGet(CafeVO::new).getCafeName()).isEqualTo("카페베네");
    }
}
