package com.app.osca.dao;

import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.mapper.AdminStudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminStudyDAO {
    private final AdminStudyMapper adminStudyMapper;

    //    관리자 스터디 게시글 불러오기
    public List<AdminStudyDTO> findAllStudy(Pagination pagination){
        return adminStudyMapper.selectAllStudy(pagination);
    }

    //    관리자 전체 게시글 불러오기
    public List<AdminStudyDTO> findAllStudyAndCafe(Pagination pagination){
        return adminStudyMapper.selectAllStudyAndCafe(pagination);
    }

    //   <!-- 관리자 전체 신고 게시글 불러오기 -->
    public List<AdminStudyDTO> findAllReportedPost(Pagination pagination){
        return adminStudyMapper.selectReportedStudyAndCafe(pagination);
    }

    //     <!-- 관리자 전체 삭제 게시글 불러오기 -->
    public List<AdminStudyDTO> findAllDeletedPost(Pagination pagination){
        return adminStudyMapper.selectDeletedStudyAndCafe(pagination);
    }

    //    <!--    관리자 스터디 글 블락-->
    public void updateStudyBlock(Long id){
        adminStudyMapper.updateStudyBlock(id);
    }

    //    <!--    관리자 스터디 글 복구-->
    public void updateStudyUnblock(Long id){
        adminStudyMapper.updateStudyUnblock(id);
    }

    //    전체 게시글 총 개수
    public int findCountOfPostSC() {
        return adminStudyMapper.selectCountOfStudyAndCafe();
    }

    //    스터디 게시글 총 개수-->
    public int findCountOfPostS() { return adminStudyMapper.selectCountOfStudy();
    }

    // 관리자 신고당한 게시글 총 개수-->
    public int findCountOfBlockedPost(){ return adminStudyMapper.selectCountOfBlockedStudyAndCafe();}

    // 관리자 삭제당한 게시글 총 개수-->
    public int findCountOfDeletedPost(){return adminStudyMapper.selectCountOfDeletedStudyAndCafe();}
}
