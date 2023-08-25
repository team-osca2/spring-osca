package com.app.osca.dao;

import com.app.osca.mapper.MypageCafeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MypageCafeDAO {
    private final MypageCafeMapper cafeMapper;

    //  사업자 번호 가져오기
    public String findBusinessNum(Long memberId){
        return cafeMapper.selectBusinessNum(memberId);
    }

    //  사업자 번호 수정하기
    public void setBusinessNum(String cafeBusinessNumber){
        cafeMapper.updateBusinessNum(cafeBusinessNumber);
    }
}
