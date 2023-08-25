package com.app.osca.service.general;

import com.app.osca.domain.GeneralVO;

import java.util.Optional;

public interface MypageGeneralService {

    //    일반 회원 정보 추가하기
    public void write(GeneralVO generalVO);

    //    일반 회원 정보 가져오기
    public Optional<GeneralVO> getGeneralInfo(Long memberId);

    //    일반 회원 정보 수정하기
    public void modify(GeneralVO generalVO);
}
