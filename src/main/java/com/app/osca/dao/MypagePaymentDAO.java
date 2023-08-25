package com.app.osca.dao;

import com.app.osca.domain.PaymentVO;
import com.app.osca.mapper.MypagePaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MypagePaymentDAO {
    private final MypagePaymentMapper paymentMapper;

    public void save(PaymentVO paymentVO){
        paymentMapper.insert(paymentVO);
    }
}
