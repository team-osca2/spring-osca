package com.app.osca.cafeAd.dao;

import com.app.osca.dao.CafeAdDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class CafeAdDAOTest {

    @Autowired
    private CafeAdDAO cafeAdDAO;

    @Test
    public void findByIdTest(){
        cafeAdDAO.findByID(4L).ifPresent(dto -> log.info(dto.toString()));
    }

}
