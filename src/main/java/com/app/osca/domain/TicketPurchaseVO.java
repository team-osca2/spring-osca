package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TicketPurchaseVO {
    private Long id;
    private Long ceoId;
    private Long ticketId;
    private String purchaseDate;
    private String ticketPurchaseStatus;
}
