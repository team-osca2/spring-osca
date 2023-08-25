package com.app.osca.service.cafe;

public interface MypageCafeService {
    //  사업자 번호 가져오기
    public String getBusinessNum(Long memberId);

    //  사업자 번호 수정하기
    public void modifyBusinessNum(String cafeBusinessNumber);
}
