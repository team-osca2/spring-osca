package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;

import java.util.Optional;

public interface MypageMemberService {
    //    회원 조회 (이메일, 닉네임), 회원의 닉네임 중복 검사 하기
    public Optional<MemberVO> getMemberInfo(Long id);

    //   닉네임 중복검사
    public int checkNickname(String memberNickname);

    //    회원의 닉네임 수정
    public void modifyMemberNickname(String memberNickname, Long id);

    //    회원 탈퇴
    public void remove(Long id);

    //    회원의 비밀번호 가져오기 (비밀번호 검사)
    public String checkMemberPassword(Long id);

    //    회원의 비밀번호 수정
    public void modifyPassword(String memberPassword, Long id);

    //    회원의 휴대폰 번호 수정
    public void modifyPhonenumber(String memberPhonenumber, Long id);
}
