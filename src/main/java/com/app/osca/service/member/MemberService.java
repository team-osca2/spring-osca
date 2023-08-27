package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MemberService {
//  sequence 가져오기
    public Long getSequence();

    //    아이디 중복검사
    public Optional<String> checkId(String memberEmail);

    //    회원가입
    public String join(MemberVO memberVO);

    //    로그인
    public Optional<Long> login(String memberEmail, String memberPassword);

    //    회원 조회
    public Optional<MemberVO> getMember(Long id);

//    전화번호 인증
    public String phoneNumberAuthentication(String phonenumber);

//   일반 계정 찾기 ( memberEmail 리스트 반환 )
    public void getGeneralAccounts(String memberName, String memberPhonenumber);

//    일반계정 비밀번호 재설정
    public void setGeneralAccountPassword(String memberPassword, String memberEmail);

//    일반계정 비밀번호 재설정 링크 발송
    public void sendPasswordRestLink(String memberEmail, HttpServletResponse response) throws IOException, ServletException;

//    카카오 로그인
    public void joinKakaoMember(Long id, String memberEmail);
}
