package com.app.osca.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CeoMapper {
    public void insertWelcomePoint(Long memberId);

    public void insertPoint(Long memberId);

}
