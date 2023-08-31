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
    private Long cafeAdId;
    private Long ticketDuration;
    private Long ticketPoint;
    private Integer type;

    public CafeAdUpdateDTO toCafeAdUpdateDTO(){
        return new CafeAdUpdateDTO(cafeAdId, ticketDuration, type);
    }

    @Builder
    public TicketDTO(Long cafeAdId, Long ticketDuration, Long ticketPoint, Integer type) {
        this.cafeAdId = cafeAdId;
        this.ticketDuration = ticketDuration;
        this.ticketPoint = ticketPoint;
        this.type = type;
    }
}
