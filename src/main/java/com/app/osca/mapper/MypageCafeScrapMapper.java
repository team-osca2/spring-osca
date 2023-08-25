package com.app.osca.mapper;

import com.app.osca.domain.dto.CafeScrapDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MypageCafeScrapMapper {
    //    스크랩한 카페 가져오기
    public List<CafeScrapDTO> selectByMemberId(Long memberId);

    //    스크랩한 카페 삭제하기
    public void delete(Long Id);
}
