package com.app.osca.domain.dto.ticket;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class TicketPurchaseDTO {
    private Long memberId;
    private Long ticketId;

    @Builder
    public TicketPurchaseDTO(Long memberId, Long ticketId) {
        this.memberId = memberId;
        this.ticketId = ticketId;
    }
}
