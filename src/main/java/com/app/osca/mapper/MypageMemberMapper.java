package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MypageMemberMapper {
    //    회원의 닉네임, 이메일 가져오기
    public Optional<MemberVO> selectById(Long id);

    //    회원의 닉네임 확인하기
    public int selectNickname(String memberNickname);

    //    회원의 이름 수정
    public void update(String memberNickname, Long id);

    //    회원의 비밀번호 가져오기 (비밀번호 검사)
    public String selectPassword(Long id);

    //    회원의 비밀번호 수정
    public void updatePassword(String memberPassword,Long id);

    //    회원 탈퇴
    public void delete(Long id);

    //    회원의 휴대폰 번호 수정
    public void updatePhonenumber(String memberPhonenumber, Long id);

}
