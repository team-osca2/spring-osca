package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
<<<<<<< HEAD

=======
    //    회원의 이름, 이메일, 핸드폰 번호 가져오기
    public Optional<MemberVO> selectById(Long id);

    //    수정
    public void update(MemberVO memberVO);

    //    삭제
    public void delete(Long id);
>>>>>>> 74f4fd67259b94cccb1c8a0004eb8112affce7c0
}
