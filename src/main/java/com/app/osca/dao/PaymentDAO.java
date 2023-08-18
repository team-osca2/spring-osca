package com.app.osca.dao;

import com.app.osca.mapper.PaymentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PaymentDAO {
    private final PaymentMapper paymentMapper;
}
