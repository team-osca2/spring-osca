package com.app.osca.service.admin;

import com.app.osca.domain.dto.AdminCafeAdDTO;

import java.util.List;

public interface AdminCafeAdService {
    //    관리자 스터디 게시글 불러오기
    public List<AdminCafeAdDTO> getList();

    //<!--    관리자 카페 글 블락-->
    public void remove(Long id);

    //<!--    관리자 카페 글 복구-->
    public void restore(Long id);
}
