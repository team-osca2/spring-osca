package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
    //    조회
    public Optional<MemberVO> select(Long id);

    //    수정
    public void update(MemberVO memberVO);

    //    삭제
    public void delete(Long id);
}
