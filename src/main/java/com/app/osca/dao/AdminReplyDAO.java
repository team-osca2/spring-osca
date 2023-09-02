package com.app.osca.dao;

import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.mapper.AdminReplyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminReplyDAO {
    private final AdminReplyMapper adminReplyMapper;

    //    <!-- 관리자 전체 댓글 목록-->
    public List<AdminReplyDTO> findAll(Pagination pagination){
        return adminReplyMapper.selectAll(pagination);
    }

    //    <!-- 관리자 삭제 댓글 목록-->
    public List<AdminReplyDTO> findDeleted(Pagination pagination){
        return adminReplyMapper.selectDeleted(pagination);
    }

    //    <!-- 관리자 신고당한 댓글 목록-->
    public List<AdminReplyDTO> findReported(Pagination pagination){
        return adminReplyMapper.selectReported(pagination);
    }

    //    <!--    관리자 삭제 복구-->
    public void setReplyBlock(Long id){adminReplyMapper.updateReplyBlock(id);}
    //    <!--    관리자 스터디 글 복구-->
    public void setReplyRestore(Long id){adminReplyMapper.updateReplyRestore(id);}

    //    <!-- 관리자 댓글 총 개수-->
    public int findCountOfReplies(){
        return adminReplyMapper.selectCountOfReplies();
    }

    //    <!-- 관리자 신고 개수-->
    public int selectCountOfReportedReplies(){
        return adminReplyMapper.selectCountOfReportedReplies();
    }

    //    <!-- 관리자 삭제 개수-->
    public int selectCountOfDeletedReplies(){
        return adminReplyMapper.selectCountOfDeletedReplies();
    }
}
