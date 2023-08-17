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
    private String paymentProductNumber;
    private String paymentProductQuantity;
    private String paymentTotalPrice;
    private String paymentStatus;
    private String paymentCardNumber;
    private String paymentAuthorizationDate;
    private String paymentCancellationDate;

}
