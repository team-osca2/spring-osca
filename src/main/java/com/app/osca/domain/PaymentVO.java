package com.app.osca.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
public class PaymentVO {
    private Long id;
    private Long memberId;
    private String paymentPrice;
    private String paymentDate;
    private Long paymentStatus;
}
