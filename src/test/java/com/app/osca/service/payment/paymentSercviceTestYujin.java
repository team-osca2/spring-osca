package com.app.osca.service.payment;

import com.app.osca.domain.PaymentVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class paymentSercviceTestYujin {
    @Autowired
    private MypagePaymentService paymentService ;

    @Test
    public void insertTest(){
        PaymentVO paymentVO = new PaymentVO();
        paymentVO.setMemberId(2L);
        paymentVO.setPaymentStatus(0L);
        paymentVO.setPaymentPrice("50000");
        paymentService.write(paymentVO);
    }
}

