package com.app.osca.ticket.service;

import com.app.osca.service.ticket.TicketService.TicketService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketServiceTest {

    @Autowired
    private TicketService ticketService;

    @Test
    public void getAllTest(){
        assertThat(
                ticketService.getAll().get(0).getTicketPoint()
        ).isEqualTo(10000);
    }

}
