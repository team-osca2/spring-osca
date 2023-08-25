package com.app.osca.service.cafeScrap;

import com.app.osca.domain.dto.CafeScrapDTO;

import java.util.List;

public interface MypageCafeScrapService {
    //    스크랩한 카페 가져오기
    public List<CafeScrapDTO> getList(Long memberId);

    //    스크랩한 카페 삭제하기
    public void remove(Long id);
}
