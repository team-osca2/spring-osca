package com.app.osca.service.admin;

import com.app.osca.domain.FaqVO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;

import java.util.List;

public interface AdminPaymentService {
    //    관리자 결제내역 불러오기
    public List<AdminPaymentDTO> getList(Pagination pagination);

    //    개수-->
    public int getTotalNum();

    //    게시글 추가
    public void write(FaqVO faqVO);

}
