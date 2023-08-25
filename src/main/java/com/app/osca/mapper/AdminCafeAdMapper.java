package com.app.osca.mapper;

import com.app.osca.domain.dto.CafeAdDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminCafeAdMapper {
    //    관리자 스터디 게시글 불러오기
    public List<CafeAdDTO> selectAllCafePost();

    //<!--    관리자 카페 글 블락-->
    public void updateCafeBlock(Long id);

    //<!--    관리자 카페 글 복구-->
    public void updateCafeUnblock(Long id);
}
