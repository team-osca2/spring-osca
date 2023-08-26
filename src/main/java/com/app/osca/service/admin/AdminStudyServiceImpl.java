package com.app.osca.service.admin;

import com.app.osca.dao.AdminStudyDAO;
import com.app.osca.domain.dto.AdminStudyDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminStudyServiceImpl implements AdminStudyService{
    final private AdminStudyDAO adminStudyDAO;


    @Override
    public List<AdminStudyDTO> getList() {
         return adminStudyDAO.findAll();
    }

    @Override
    public void remove(Long id) {
        adminStudyDAO.updateStudyBlock(id);
    }

    @Override
    public void recover(Long id) {
        adminStudyDAO.updateStudyUnblock(id);
    }

}
