package com.app.osca.mapper;

import com.app.osca.domain.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MypageMemberMapper {
    //    회원의 이름, 이메일, 핸드폰 번호 가져오기
    public Optional<MemberVO> selectById(Long id);

    //    회원의 정보 이름, 핸드폰 번호 수정
    public void update(MemberVO memberVO);

    //    회원의 비밀번호 가져오기 (비밀번호 검사)
    public String selectPassword(Long id);

    //    회원의 비밀번호 수정
    public void updatePassword(String memberPassword);

    //    회원 탈퇴
    public void delete(Long id);


//    시퀸스
    public Long selectMemberSequence();
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

//    <!--    로그인    -->
//    <select id="selectForLogin" resultType="int">
//    SELECT ID FROM TBL_MEMBER WHERE MEMBER_EMAIL = #{memberEmail} AND MEMBER_PASSWORD = #{memberPassword}  <!-- 세선에 들어갈 회원번호  -->
//    </select>
//
//    <!--    계정찾기    -->
//    <select id="selectMemberEmail" resultType="string">
//        <!--  닉네임이랑 전화번호를 가지고 멤버를 조회 성공하면 Integer로 전화번호 반환 -->
//    SELECT MEMBER_EMAIL FROM TBL_MEMBER WHERE MEMBER_NAME = #{memberName} AND MEMBER_PHONENUMBER = #{memberPhonenumber}
//    </select>
//    <!--    비밀번호 재설정    -->
//    <update id="updateMemberPassword">
//    UPDATE TBL_MEMBER
//    SET MEMBER_PASSWORD = #{memberPassword}
//    WHERE MEMBER_EMAIL = #{memberEmail}
//    </update>
}
