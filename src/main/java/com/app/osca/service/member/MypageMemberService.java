package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;

import java.util.Optional;

public interface MypageMemberService {
    //    회원 조회 (이메일, 닉네임, 휴대폰 번호) 
    public Optional<MemberVO> getMemberInfo(Long id);

    //    회원 정보 수정
    public void modify(MemberVO memberVO);

    //    회원 탈퇴
    public void remove(Long id);

    //    회원의 비밀번호 가져오기 (비밀번호 검사)
    public String checkMemberPassword(Long id);

    //    회원의 비밀번호 수정
    public void modifyPassword(String memberPassword);
}
