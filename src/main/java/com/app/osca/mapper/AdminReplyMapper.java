package com.app.osca.mapper;

import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface AdminReplyMapper {

    //    <!-- 관리자 전체 댓글 목록-->
    public List<AdminReplyDTO> selectAll(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 삭제 댓글 목록-->
    public List<AdminReplyDTO> selectDeleted(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 신고당한 댓글 목록-->
    public List<AdminReplyDTO> selectReported(@Param("pagination") Pagination pagination);

    //    <!-- 관리자 댓글 총 개수-->
    public int selectCountOfReplies();

    //    <!-- 관리자 신고 개수-->
    public int selectCountOfReportedReplies();

    //    <!-- 관리자 삭제 개수-->
    public int selectCountOfDeletedReplies();


    //    <!--    관리자 삭제 복구-->
    public void updateReplyBlock(Long id);

    //    <!--    관리자 스터디 글 복구-->
    public void updateReplyRestore(Long id);

}
