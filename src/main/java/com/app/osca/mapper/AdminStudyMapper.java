package com.app.osca.mapper;

import com.app.osca.domain.StudyVO;
import com.app.osca.domain.dto.StudyDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminStudyMapper {
    public void insert(StudyVO studyVO);
    public void insert(StudyDTO studyDTO);
    //    관리자 스터디 게시글 불러오기
    public List<StudyDTO> selectAllStudy();

    //    관리자 전체 게시글 불러오기
//    public List<StudyDTO> selectAllPost();

//    <!--    관리자 스터디 글 블락-->
    public void updateStudyBlock(Long id);

//    <!--    관리자 카페 글 복구-->
    public void updateStudyUnblock(Long id);

}
