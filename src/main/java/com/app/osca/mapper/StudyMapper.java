package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudyMapper {
    public void insert(StudyVO studyVO);

//    public List<StudyVO> selectStudies(@Param("pagination")Pagination pagination, @Param("search")Search search);

    
}
