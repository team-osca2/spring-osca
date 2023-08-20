package com.app.osca.mapper;

import com.app.osca.domain.StudyImageVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyImageMapper {
    public void insert(StudyImageVO studyImageVO);
}
