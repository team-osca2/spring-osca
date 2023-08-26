package com.app.osca.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class AdminPaymentDTO {
    private Long id;
    private String paymentPrice;
    private String paymentDate;
    private String paymentStatus;
    private String memberName;
    private String memberNickname;
}
