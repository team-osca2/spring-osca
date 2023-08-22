package com.app.osca.mapper;

import com.app.osca.domain.GeneralVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface GeneralMapper {
    //    일반 회원 정보 추가하기
    public void insert(GeneralVO generalVO);

    //    일반 회원 정보 가져오기
    public Optional<GeneralVO> selectById(Long id);

    //    일반 회원 정보 수정하기
    public void update(GeneralVO generalVO);

}
