package com.app.osca.domain.dto.ceo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class CeoDTO {
    private Long memberId;
    private Long ticketPoint;

    @Builder
    public CeoDTO(Long memberId, Long ticketPoint) {
        this.memberId = memberId;
        this.ticketPoint = ticketPoint;
    }
}
