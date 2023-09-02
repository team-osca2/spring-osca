package com.app.osca.ceo.dao;

import com.app.osca.dao.CeoDAO;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.osca.domain.dto.ceo.CeoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CeoDAOTest {

    @Autowired
    private CeoDAO ceoDAO;

    @Test
    public void modifyTest(){
        CeoDTO ceoDTO = CeoDTO.builder()
                .memberId(2L)
                .ticketPoint(10000L)
                .build();
        assertThat(ceoDAO.modify(ceoDTO)).isEqualTo(0);
    }

    @Test
    public void findByMemberIdTest(){
        assertThat(ceoDAO.findByMemberId(3L).orElse(0)).isEqualTo(980000);
    }

}
