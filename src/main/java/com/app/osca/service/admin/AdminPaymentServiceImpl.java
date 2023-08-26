package com.app.osca.service.admin;

import com.app.osca.dao.AdminPaymentDAO;
import com.app.osca.dao.AdminStudyDAO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminPaymentServiceImpl implements AdminPaymentService {
    final private AdminPaymentDAO adminPaymentDAO;
    @Override
    public List<AdminPaymentDTO> getList() {
        return adminPaymentDAO.findAll();
    }
}
