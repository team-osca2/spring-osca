package com.app.osca.service.payment;

import com.app.osca.domain.PaymentVO;

public interface MypagePaymentService {
//    결제 내역 추가
    public void write(PaymentVO paymentVO);
}
