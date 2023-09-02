package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.paging.Pagination;

import java.util.List;

public interface AdminReplyService {


    //    <!-- 관리자 전체 댓글 목록-->
    public List<AdminReplyDTO> getList(Pagination pagination);

    //    <!-- 관리자 삭제 댓글 목록-->
    public List<AdminReplyDTO> getListDeleted(Pagination pagination);

    //    <!-- 관리자 신고당한 댓글 목록-->
    public List<AdminReplyDTO> getListReported(Pagination pagination);

    //    <!-- 관리자 댓글 총 개수-->
    public int getCountOfReplies();

    //    <!-- 관리자 신고 개수-->
    public int getCountOfReportedReplies();

    //    <!-- 관리자 삭제 개수-->
    public int getCountOfDeletedReplies();

    //
    public void recover(Long id);
    public void delete(Long id);
}
