package com.app.osca.dao;

import com.app.osca.domain.MemberVO;
import com.app.osca.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
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

//   일반 로그인
    public Optional<Long> findByEmailAndPassword(String memberEmail, String memberPassword){
        return memberMapper.selectForLogin(memberEmail, memberPassword);
    }

//   일반 계정 찾기
    public List<String> findByMemberNameAndPhonenumber(String memberName, String memberPhonenumber){
        return memberMapper.selectMemberEmail(memberName, memberPhonenumber);
    }

//    일반계정 비밀번호 재설정
    public void resetPassword(String memberPassword, String memberEmail){
        memberMapper.updateMemberPassword(memberPassword, memberEmail);
    }

//    카카오 로그인
    public void saveKakaoMember(Long id, String memberNickname, String memberEmail){
        memberMapper.insertKakaoMember(id, memberNickname, memberEmail);
    }

}