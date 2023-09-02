package com.app.osca.mapper;

import com.app.osca.domain.FaqVO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminPaymentMapper {
    //    관리자 결제내역 불러오기
    public List<AdminPaymentDTO> selectAll(@Param("pagination") Pagination pagination);

    //    총 개수-->
    public int selectCountOfPurchase();

    //    게시글 추가
    public void insert(FaqVO faqVO);

}
