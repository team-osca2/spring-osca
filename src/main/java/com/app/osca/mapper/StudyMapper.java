package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyMapper {
    public void insert(StudyVO studyVO);

    //    관리자 스터디 게시글 불러오기
//    public List<studyDTO> selectAllStudyPost(Long studyId);

}
