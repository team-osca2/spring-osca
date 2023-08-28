package com.app.osca.mapper;

import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface AdminStudyMapper {

    //    관리자 스터디 게시글 불러오기
    public List<AdminStudyDTO> selectAllStudy(@Param("pagination") Pagination pagination);
    //    관리자 전체 게시글 불러오기
    public List<AdminStudyDTO> selectAllStudyAndCafe(@Param("pagination") Pagination pagination);

    //   <!-- 관리자 전체 신고 게시글 불러오기 -->
    public List<AdminStudyDTO> selectReportedStudyAndCafe(@Param("pagination") Pagination pagination);

    //     <!-- 관리자 전체 삭제 게시글 불러오기 -->
    public List<AdminStudyDTO> selectDeletedStudyAndCafe(@Param("pagination") Pagination pagination);

    //    <!--    관리자 스터디 글 블락-->
    public void updateStudyBlock(Long id);

    //    <!--    관리자 스터디 글 복구-->
    public void updateStudyUnblock(Long id);

    //    게시글 총 개수
    public int selectCountOfStudyAndCafe();

    //     스터디 총 개수-->
    public int selectCountOfStudy();

    // 관리자 신고당한 게시글 총 개수-->
    public int selectCountOfBlockedStudyAndCafe();

    // 관리자 삭제당한 게시글 총 개수-->
    public int selectCountOfDeletedStudyAndCafe();


}
