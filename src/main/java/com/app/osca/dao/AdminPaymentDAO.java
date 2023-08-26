package com.app.osca.dao;

import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.mapper.AdminPaymentMapper;
import com.app.osca.mapper.AdminStudyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AdminPaymentDAO {
    private final AdminPaymentMapper adminPaymentMapper;

    //    관리자 결제내역 불러오기
    public List<AdminPaymentDTO> findAll(){
        return adminPaymentMapper.selectAll();
    }
}
