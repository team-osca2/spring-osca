package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminStudyDTO;

import java.util.List;


public interface AdminStudyService {

    //    관리자 스터디 게시글 불러오기
    public List<AdminStudyDTO> getList();

    //    관리자 전체 게시글 불러오기
//    public List<StudyDTO> selectAllPost();

    //    <!--    관리자 스터디 글 블락-->
    public void remove(Long id);

    //    <!--    관리자 스터디 글 복구-->
    public void recover(Long id);
}
