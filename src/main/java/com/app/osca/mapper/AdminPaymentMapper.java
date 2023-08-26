package com.app.osca.mapper;

import com.app.osca.domain.dto.AdminPaymentDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminPaymentMapper {
    //    관리자 결제내역 불러오기
    public List<AdminPaymentDTO> selectAll();
}
