package com.app.osca.dao;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.mapper.AdminStudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminStudyDAO {
    private final AdminStudyMapper adminStudyMapper;
    //    관리자 스터디 게시글 불러오기
    public List<AdminStudyDTO> findAll(){
            return adminStudyMapper.selectAllStudy();
    }

    //    관리자 전체 게시글 불러오기
//    public List<StudyDTO> selectAllPost()

    //    <!--    관리자 스터디 글 블락-->
    public void updateStudyBlock(Long id){
        adminStudyMapper.updateStudyBlock(id);
    }

    //    <!--    관리자 스터디 글 복구-->
    public void updateStudyUnblock(Long id){
        adminStudyMapper.updateStudyUnblock(id);
    }
}
