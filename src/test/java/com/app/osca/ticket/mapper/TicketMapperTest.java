package com.app.osca.ticket.mapper;

import com.app.osca.mapper.TicketMapper;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TicketMapperTest {

    @Autowired
    private TicketMapper ticketMapper;

    @Test
    public void selectAllTest() throws Exception{
        assertThat(
            ticketMapper.selectAll().get(0).getTicketPoint()
        ).isEqualTo(10000);
    }

}
