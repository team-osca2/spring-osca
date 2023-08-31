package com.app.osca.domain.dto.ticket;

import com.app.osca.domain.dto.cafeAd.CafeAdUpdateDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class TicketDTO {
    private Long memberId;
    private Long cafeAdId;
    private Long ticketDuration;
    private Long ticketPoint;
    private Long ticketId;
    private Integer type;

    public CafeAdUpdateDTO toCafeAdUpdateDTO(){
        return new CafeAdUpdateDTO(cafeAdId, ticketDuration, type);
    }

    public TicketPurchaseDTO toTicketPurchaseDTO() {return new TicketPurchaseDTO(memberId, ticketId);}

    @Builder
    public TicketDTO(Long memberId, Long cafeAdId, Long ticketDuration, Long ticketPoint, Long ticketId, Integer type) {
        this.memberId = memberId;
        this.cafeAdId = cafeAdId;
        this.ticketDuration = ticketDuration;
        this.ticketPoint = ticketPoint;
        this.ticketId = ticketId;
        this.type = type;
    }
}
