package com.app.osca.ceo.service;

import com.app.osca.domain.dto.ceo.CeoDTO;
import com.app.osca.service.ceo.CeoService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CeoServiceTest {

    @Autowired
    private CeoService ceoService;

    @Test
    public void usePointTest(){
        CeoDTO ceoDTO = CeoDTO.builder()
                .memberId(3L)
                .ticketPoint(10000L)
                .build();
        assertThat(ceoService.usePoint(ceoDTO)).isEqualTo(1);
    }

    @Test
    public void getPointTest(){
        assertThat(ceoService.getPoint(3L).orElse(0)).isEqualTo(970000);
    }
}
