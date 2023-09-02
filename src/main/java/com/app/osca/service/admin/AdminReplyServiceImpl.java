package com.app.osca.service.admin;

import com.app.osca.dao.AdminReplyDAO;
import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.paging.Pagination;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminReplyServiceImpl implements AdminReplyService {
    final private AdminReplyDAO adminReplyDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminReplyDTO> getList(Pagination pagination) {
        final List<AdminReplyDTO> replyLists = adminReplyDAO.findAll(pagination);
        return replyLists;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminReplyDTO> getListDeleted(Pagination pagination) {
        final List<AdminReplyDTO> replyLists = adminReplyDAO.findDeleted(pagination);
        return replyLists;

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminReplyDTO> getListReported(Pagination pagination) {
        List<AdminReplyDTO> replyLists = adminReplyDAO.findReported(pagination);
        return replyLists;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getCountOfReplies() {
        return adminReplyDAO.findCountOfReplies();
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getCountOfReportedReplies() {
        return adminReplyDAO.selectCountOfReportedReplies();
    }

    @Override
    public int getCountOfDeletedReplies() {
        return adminReplyDAO.selectCountOfDeletedReplies();
    }

    @Override
    public void recover(Long id) {
        adminReplyDAO.setReplyRestore(id);
    }

    @Override
    public void delete(Long id) {
        adminReplyDAO.setReplyBlock(id);
    }



}