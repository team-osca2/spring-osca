package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.paging.Pagination;

import java.util.List;

public interface AdminCafeAdService {

    //    관리자 카페 게시글 불러오기
    public List<AdminCafeAdDTO> getList(Pagination pagination);

    //<!--    관리자 카페 글 블락-->
    public void remove(Long id);

    //<!--    관리자 카페 글 복구-->
    public void restore(Long id);

    //    카페 게시글 총 개수-->
    public int getTotalCafe();

}
