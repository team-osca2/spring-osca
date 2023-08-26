package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.dto.AdminStudyDTO;

import java.util.List;

public interface AdminPaymentService {
    //    관리자 결제내역 불러오기
    public List<AdminPaymentDTO> getList();

}
