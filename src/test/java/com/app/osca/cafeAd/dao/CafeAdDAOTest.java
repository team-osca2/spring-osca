package com.app.osca.cafeAd.dao;

import com.app.osca.dao.CafeAdDAO;
import com.app.osca.domain.UpdateStateEnum;
import com.app.osca.domain.dto.cafeAd.CafeAdUpdateDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CafeAdDAOTest {

    @Autowired
    private CafeAdDAO cafeAdDAO;

    @Test
    public void findCafeAndCafeAdByIdTest(){
        cafeAdDAO.findCafeAndCafeAdById(4L).ifPresent(dto -> log.info(dto.toString()));
    }

    @Test
    public void findAllByMemberIdAndBlockedIsOrderByCafeAdDeadlineDateOrderByIdTest(){
        assertThat((cafeAdDAO.findAllByMemberIdAndBlockedIsOrderByCafeAdDeadlineDateOrderById(3L, 0).get(0)).getId()).isEqualTo(21L);
    }

    @Test
    public void modifyTest(){
        UpdateStateEnum state = UpdateStateEnum.SUCCESS;
        CafeAdUpdateDTO cafeAdUpdateDTO = CafeAdUpdateDTO.builder()
                .id(101L)
                .ticketDuration(0L)
                .type(0)
                .build();
        assertThat(cafeAdDAO.modify(cafeAdUpdateDTO)).isEqualTo(state);
    }

}
