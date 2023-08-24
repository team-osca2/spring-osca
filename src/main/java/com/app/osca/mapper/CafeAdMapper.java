package com.app.osca.mapper;

import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.paging.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface CafeAdMapper {
    public void selectAll(Criteria criteria);

    public CafeAdDetailDTO select(Long id);
}
