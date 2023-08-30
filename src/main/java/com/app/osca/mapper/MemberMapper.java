package com.app.osca.mapper;

import com.app.osca.domain.ImageVO;
import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MemberMapper {

    //    회원의 이름, 이메일, 핸드폰 번호 가져오기
    public Optional<MemberVO> selectById(Long id);

    //    수정
    public void update(MemberVO memberVO);

    //    삭제
    public void delete(Long id);

//    회원번호 시퀸스
    public Long selectMemberSequence();
//    닉네임 시퀸스
    public Long selectNickNameSequence();
//    닉네임 중복검사
    public Optional<String> selectForNickNameCheck(String memberNickname);
//   아이디 중복 검사
    public Optional<String> selectForIdCheck(String memberEmail);

//    일반계정 가입
    public void insertGeneral(MemberVO memberVO);

//    첫 카페 계정인지 검사
    public Long selectForCafeCheck(String memberPhonenumber);

//    카페 계정 가입
    public void insertCafe(MemberVO memberVO);

//    일반 로그인
    public Optional<Long> selectForLogin(String memberEmail, String memberPassword);

//    일반 계정찾기
    public List<String> selectMemberEmail(String memberName, String memberPhonenumber);

//    일반계정 비밀번호 재설정
    public void updateMemberPassword(String memberPassword, String memberEmail);

//    카카오 로그인
    public void insertKakaoMember(Long id, String memberNickname, String memberEmail);

//    헤더 회원 이미지 가져오기
    public Optional<ImageVO> selectMemberImage(Long id);
}
