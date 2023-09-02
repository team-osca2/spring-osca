package com.app.osca.domain.dto.cafeAd;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Data
public class CafeAdUpdateDTO {
    private Long id;
    private Long ticketDuration;
    private Integer type;

    @Builder
    public CafeAdUpdateDTO(Long id, Long ticketDuration, Integer type) {
        this.id = id;
        this.ticketDuration = ticketDuration;
        this.type = type;
    }
}
