package com.app.osca.mapper;

import com.app.osca.domain.PaymentVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypagePaymentMapper {
    //    결제 정보 추가하기
    public void insert(PaymentVO paymentVO);
}
