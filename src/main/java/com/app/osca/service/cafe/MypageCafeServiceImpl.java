package com.app.osca.service.cafe;

import com.app.osca.dao.MypageCafeDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MypageCafeServiceImpl implements MypageCafeService {
    private final MypageCafeDAO cafeDAO;

    @Override
    public String getBusinessNum(Long memberId) {
        return cafeDAO.findBusinessNum(memberId);
    }

    @Override
    public void modifyBusinessNum(String cafeBusinessNumber) {
        cafeDAO.setBusinessNum(cafeBusinessNumber);
    }
}
