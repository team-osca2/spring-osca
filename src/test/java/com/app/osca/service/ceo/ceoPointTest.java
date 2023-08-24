package com.app.osca.service.ceo;

import com.app.osca.dao.CeoDAO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ceoPointTest {

    @Autowired
    private CeoService ceoService;


    @Test
    public void ceoWelcomePoint(){
        ceoService.joinPoint(90L, true);
    }
}
