package com.app.osca.dao.cafe;

import com.app.osca.dao.CafeDAO;
import com.app.osca.domain.CafeVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeDAOTest {

    @Autowired
    private CafeDAO cafeDAO;

    @Test
    public void findAllTest(){
        cafeDAO.findAll().stream().map(CafeVO::toString).forEach(log::info);
    }

}
