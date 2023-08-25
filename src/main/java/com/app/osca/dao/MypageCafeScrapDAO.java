package com.app.osca.dao;

import com.app.osca.domain.dto.CafeScrapDTO;
import com.app.osca.mapper.MypageCafeScrapMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MypageCafeScrapDAO {
    private final MypageCafeScrapMapper cafeScrapMapper;

    //    스크랩한 카페 가져오기
    public List<CafeScrapDTO> findBymemberId(Long memberId){
        return cafeScrapMapper.selectByMemberId(memberId);
    }

    //    스크랩한 카페 삭제하기
    public void delete(Long id){
        cafeScrapMapper.delete(id);
    }
}
