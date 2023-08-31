package com.app.osca.domain.dto.ticket;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TicketDTO {
    private Long cafeAdId;
    private Long ticketDuration;
    private Long ticketPoint;
    private Integer type;
}
