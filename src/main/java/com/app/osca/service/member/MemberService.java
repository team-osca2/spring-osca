package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;

import java.util.Optional;

public interface MemberService {
    //    아이디 중복검사
    public Optional<MemberVO> checkId(String memberId);

    //    회원가입
    public void join(MemberVO memberVO);

    //    로그인
    public Optional<Long> login(String memberId, String memberPassword);

    //    회원 조회
    public Optional<MemberVO> getMember(Long id);
}
