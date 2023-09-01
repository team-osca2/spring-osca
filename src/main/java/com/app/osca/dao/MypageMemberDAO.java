package com.app.osca.dao;

import com.app.osca.domain.MemberVO;
import com.app.osca.mapper.MypageMemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MypageMemberDAO {
    private final MypageMemberMapper memberMapper;

    //   회원 조회
    public Optional<MemberVO> findById(Long id) {
        return memberMapper.selectById(id);
    }

    //   닉네임 중복검사
    public int findNickname(String memberNickname){
        return memberMapper.selectNickname(memberNickname);
    }

    //   회원 정보 수정 (이름, 폰번호)
    public void setMemberNickName(String memberNickName,Long id){
        memberMapper.update(memberNickName,id);
    }

    //   회원 탈퇴
    public void delete(Long id){
        memberMapper.delete(id);
    }

    //    회원의 비밀번호 가져오기 (비밀번호 검사)
    public String findPassword(Long id){return memberMapper.selectPassword(id);}

    //    회원의 비밀번호 수정
    public void setPassword(String memberPassword, Long id){
        memberMapper.updatePassword(memberPassword,id);
    }

    //    회원의 휴대폰 번호 수정
    public void setPhonenumber(String memberPhonenumber, Long id){
        memberMapper.updatePhonenumber(memberPhonenumber, id);
    }
}