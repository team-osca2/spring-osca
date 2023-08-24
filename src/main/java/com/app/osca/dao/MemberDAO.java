package com.app.osca.dao;

import com.app.osca.domain.MemberVO;
import com.app.osca.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//   회원번호 시퀀스
    public Long findMemberSequence(){ return memberMapper.selectMemberSequence(); }

//   닉네임 시퀸스
    public Long findNickNameSequence() { return memberMapper.selectNickNameSequence(); }

//    닉네임 중복검사
    public Optional<String> findByNickname(String memberNickname){
        return memberMapper.selectForNickNameCheck(memberNickname);
    }

//   아이디 중복 검사
    public Optional<String> findByEmail(String memberEmail) {
        return memberMapper.selectForIdCheck(memberEmail);
    }

//    일반계정 가입
    public void saveGeneral(MemberVO memberVO) {
        memberMapper.insertGeneral(memberVO);
    }

//    첫 카페 계정인지 검사
    public boolean isFirstCafeAccount(String memberPhonenumber) {
        return memberMapper.selectForCafeCheck(memberPhonenumber) == 0;
    }

//    카페 계정 가입
    public void saveCafe(MemberVO memberVO) {
        memberMapper.insertCafe(memberVO);
    }
}