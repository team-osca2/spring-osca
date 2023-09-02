package com.app.osca.ticket.dao;

import com.app.osca.dao.TicketDAO;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketDAOTest {

    @Autowired
    private TicketDAO ticketDAO;

    @Test
    public void findAllTest(){
        assertThat(
                ticketDAO.findAll().get(0).getTicketPoint()
        ).isEqualTo(10000);
    }

}
