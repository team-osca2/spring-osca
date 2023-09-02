package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminPaymentDTO {
    private Long id;
    private String ticketPoint;
    private String ticketPurchaseDate;
    private Integer status;
    private String memberName;
    private String memberNickname;
}
