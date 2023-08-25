package com.app.osca.service.payment;

import com.app.osca.dao.MypagePaymentDAO;
import com.app.osca.domain.PaymentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypagePaymentServiceImpl implements MypagePaymentService {
    final private MypagePaymentDAO paymentDAO;

    @Override
    public void write(PaymentVO paymentVO) {
        paymentDAO.save(paymentVO);
    }
}
