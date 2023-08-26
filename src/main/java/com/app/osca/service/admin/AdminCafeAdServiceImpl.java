package com.app.osca.service.admin;

import com.app.osca.dao.AdminCafeAdDAO;
import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.mapper.AdminCafeAdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminCafeAdServiceImpl implements AdminCafeAdService {
    private final AdminCafeAdDAO adminCafeAdDAO;
    @Override
    public List<AdminCafeAdDTO> getList() {
        return null;
    }

    @Override
    public void remove(Long id) {
        adminCafeAdDAO.setCafeBlock(id);
    }

    @Override
    public void restore(Long id) {
        adminCafeAdDAO.setCafeUnblock(id);
    }
}
