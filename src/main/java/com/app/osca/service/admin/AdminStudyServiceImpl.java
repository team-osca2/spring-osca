package com.app.osca.service.admin;

import com.app.osca.dao.AdminStudyDAO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStudyServiceImpl implements AdminStudyService{
    final private AdminStudyDAO adminStudyDAO;

    //    관리자 전체 게시글 불러오기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminStudyDTO> getListStudyNCafe(Pagination pagination) {
        final List<AdminStudyDTO> studyCafePosts = adminStudyDAO.findAllStudyAndCafe(pagination);
        return studyCafePosts;
    }



    //    관리자 스터디 게시글 불러오기
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminStudyDTO> getList(Pagination pagination) {
        final List<AdminStudyDTO> studyPosts = adminStudyDAO.findAllStudy(pagination);
        return studyPosts;
    }

    //   <!-- 관리자 전체 신고 게시글 불러오기 -->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminStudyDTO> getListReported(Pagination pagination) {
        final List<AdminStudyDTO> reportedPosts = adminStudyDAO.findAllReportedPost(pagination);
        return reportedPosts;
    }
    //     <!-- 관리자 전체 삭제 게시글 불러오기 -->
    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminStudyDTO> getListDeleted(Pagination pagination) {
        final List<AdminStudyDTO> deletedPosts = adminStudyDAO.findAllDeletedPost(pagination);
        return deletedPosts;
    }
    //    <!--    관리자 스터디 글 삭제-->
    @Override
    public void remove(Long id) {
        adminStudyDAO.updateStudyBlock(id);
    }

    //    <!--    관리자 스터디 글 복구-->
    @Override
    public void recover(Long id) {
        adminStudyDAO.updateStudyUnblock(id);
    }

    //    게시글 총 개수
    @Override
    public int getTotalStudyAndCafe() {
        return adminStudyDAO.findCountOfPostSC();
    }

    @Override
    public int getTotalStudy() {
        return adminStudyDAO.findCountOfPostS();
    }

    @Override
    public int getTotalBlockedStudyAndCafe() {
        return adminStudyDAO.findCountOfBlockedPost();
    }

    @Override
    public int getTotalDeletedStudyAndCafe() {
        return adminStudyDAO.findCountOfDeletedPost();
    }


}
