package com.app.osca.mapper;

import com.app.osca.domain.dto.ceo.CeoDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CeoMapper {
    public void insertWelcomePoint(Long memberId);

    public void insertPoint(Long memberId);

    public Integer updatePoint(CeoDTO ceoDTO);

    public Integer selectMemberPoint(Long memberId);
}
