package com.app.osca.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MypageCafeMapper {
//  사업자 번호 가져오기
    public String selectBusinessNum(Long memberId);

//  사업자 번호 수정하기
    public void updateBusinessNum(String cafeBusinessNumber);
}
