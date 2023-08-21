package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyMapper {
    public void insert(StudyVO studyVO);
}
