package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudyMapper {
    public void insert(StudyVO studyVO);

    //    스터디 목록
//    public List<StudyVO> selectStudies(@Param("pagination")Pagination pagination, @Param("search")Search search);

    //    관리자 스터디 게시글 불러오기
//    public List<studyDTO> selectAllStudyPost(Long studyId);

}
