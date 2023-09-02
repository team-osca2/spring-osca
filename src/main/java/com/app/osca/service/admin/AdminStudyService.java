package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;

import java.util.List;


public interface AdminStudyService {
    //    <!--    관리자 스터디 글 블락-->
    public void remove(Long id);

    //    관리자 스터디 게시글 불러오기
    public List<AdminStudyDTO> getList(Pagination pagination);

    //    관리자 전체 게시글 불러오기
    public List<AdminStudyDTO> getListStudyNCafe(Pagination pagination);

    //   <!-- 관리자 전체 신고 게시글 불러오기 -->
    public List<AdminStudyDTO> getListReported(Pagination pagination);

    //     <!-- 관리자 전체 삭제 게시글 불러오기 -->
    public List<AdminStudyDTO> getListDeleted(Pagination pagination);



    //    <!--    관리자 스터디 글 복구-->
    public void recover(Long id);

    //    게시글 총 개수
    public int getTotalStudyAndCafe();

    //    스터디 게시글 총 개수-->
    public int getTotalStudy();

    // 관리자 신고당한 게시글 총 개수-->
    public int getTotalBlockedStudyAndCafe();

    // 관리자 삭제당한 게시글 총 개수-->
    public int getTotalDeletedStudyAndCafe();


}
