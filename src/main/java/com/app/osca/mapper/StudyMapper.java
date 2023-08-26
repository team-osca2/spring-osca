package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import com.app.osca.domain.dto.Pagination;
import com.app.osca.domain.dto.Search;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {
    public void insert(StudyVO studyVO);

    public List<StudyVO> selectStudies(@Param("pagination") Pagination pagination, @Param("search") Search search);

    public void selectOneStudy(StudyVO studyVO);



    
}
