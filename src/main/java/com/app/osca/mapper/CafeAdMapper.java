package com.app.osca.mapper;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.dto.cafeAd.CafeAdDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CafeAdMapper {
    public void selectAll(Criteria criteria);

    public CafeAdDetailDTO select(Long id);

    public List<CafeVO> selectAllCafePost(Long cafeAdId);

    public List<CafeAdDTO> selectAllMyCafes(Long memberId, Integer blocked);

}
