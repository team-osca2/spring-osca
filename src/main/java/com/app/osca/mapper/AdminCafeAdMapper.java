package com.app.osca.mapper;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.paging.Pagination;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminCafeAdMapper {
    //    관리자 카페 게시글 불러오기
    public List<AdminCafeAdDTO> selectAllCafePost(@Param("pagination") Pagination pagination);

    //<!--    관리자 카페 글 블락-->
    public void updateCafeBlock(Long id);

    //<!--    관리자 카페 글 복구-->
    public void updateCafeUnblock(Long id);

    //    카페 게시글 총 개수-->
    public int selectCountOfCafe();

}
