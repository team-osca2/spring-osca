package com.app.osca.ticket.mapper;

import com.app.osca.domain.dto.ticket.TicketPurchaseDTO;
import com.app.osca.mapper.TicketMapper;
import static org.assertj.core.api.Assertions.assertThat;

import com.app.osca.mapper.TicketPurchaseMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketMapperTest {

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private TicketPurchaseMapper ticketPurchaseMapper;

    @Test
    public void selectAllTest() throws Exception{
        assertThat(
            ticketMapper.selectAll().get(0).getTicketPoint()
        ).isEqualTo(10000);
    }

    @Test
    public void ticketPurchaseInsertTest(){
        TicketPurchaseDTO ticketPurchaseDTO = TicketPurchaseDTO.builder()
                .ticketId(1L)
                .memberId(3L)
                .build();
        assertThat(ticketPurchaseMapper.insert(ticketPurchaseDTO)).isEqualTo(1);
    }

}
