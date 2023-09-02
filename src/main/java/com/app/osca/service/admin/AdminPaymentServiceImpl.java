package com.app.osca.service.admin;

import com.app.osca.dao.AdminPaymentDAO;
import com.app.osca.dao.AdminStudyDAO;
import com.app.osca.domain.FaqVO;
import com.app.osca.domain.MemberVO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.paging.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AdminPaymentServiceImpl implements AdminPaymentService {
    final private AdminPaymentDAO adminPaymentDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<AdminPaymentDTO> getList(Pagination pagination) {
        final List<AdminPaymentDTO> payList = adminPaymentDAO.findAll(pagination);
        return payList;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getTotalNum() {
        return adminPaymentDAO.findCountOfPayments();
    }

    @Override
    public void write(FaqVO faqVO) {
//        faqVO.setId(null); // id는 자동으로 생성됩니다.
//        adminPaymentDAO.save(faqVO);;
        ;
    }
}



