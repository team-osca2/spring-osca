package com.app.osca.service.admin;

import com.app.osca.dao.AdminCafeAdDAO;
import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminCafeAdServiceImpl implements AdminCafeAdService {
    private final AdminCafeAdDAO adminCafeAdDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminCafeAdDTO> getList(Pagination pagination) {
        final List<AdminCafeAdDTO> cafePosts = adminCafeAdDAO.findAllCafePost(pagination);
        return cafePosts;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long id) {
        adminCafeAdDAO.setCafeBlock(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void restore(Long id) {
        adminCafeAdDAO.setCafeUnblock(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalCafe() {
        return adminCafeAdDAO.findCountOfPostC();
    }


}
