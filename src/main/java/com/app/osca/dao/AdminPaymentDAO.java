package com.app.osca.dao;

import com.app.osca.domain.FaqVO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.paging.Pagination;
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
    public List<AdminPaymentDTO> findAll(Pagination pagination) {
        return adminPaymentMapper.selectAll(pagination);
    }

    //    <!-- 관리자 일반 유저 총 개수-->
    public int findCountOfPayments() {
        return adminPaymentMapper.selectCountOfPurchase();
    }


    //    게시글 추가
    public void save(FaqVO faqVO) {
        adminPaymentMapper.insert(faqVO);
    }

}

