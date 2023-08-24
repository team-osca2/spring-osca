package com.app.osca.service.member;

import com.app.osca.dao.MemberDAO;
import com.app.osca.domain.MemberVO;
import com.app.osca.service.ceo.CeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final CeoService ceoService;

//    아이디 중복검사
    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return Optional.empty();
    }

//    회원가입                              완료
    @Override
    public void join(MemberVO memberVO) {

        boolean isGeneralMember = memberVO.getMemberRole() == null;

//        회원번호 생성
        Long id = memberDAO.findMemberSequence();
        memberVO.setId(id);

//        랜덤 닉네임 생성
        String[] nickNames = {"사과", "바나나", "배", "포도", "딸기", "오렌지", "파인애플", "자두", "귤", "수박"};
        final long SEQ = memberDAO.findNickNameSequence(), DIV = 10000;
        String nickname = nickNames[(int)(SEQ / DIV)] + (SEQ % DIV);
        memberVO.setMemberNickname(nickname);

//      비밀번호 암호화
        final int KEY = 3;
        String encryptedPassword = "", password = memberVO.getMemberPassword();
        for (int i = 0; i < password.length(); i++) {
            encryptedPassword += (char)(password.charAt(i) * KEY);
        }
        memberVO.setMemberPassword(encryptedPassword);

//      일반 회원이면 가입, 카페 회원이면 포인트 첫 계정인지에 따라 포인트 증정
        if ( isGeneralMember ) {
            memberDAO.saveGeneral(memberVO);
        } else {
            boolean isFirstCafeAccount = memberDAO.isFirstCafeAccount(memberVO.getMemberPhonenumber());
            memberDAO.saveCafe(memberVO);
            ceoService.joinPoint(id, isFirstCafeAccount);
        }

    }

//    로그인                                     완료
    @Override
    public Optional<Long> login(String memberEmail, String memberPassword) {
        return memberDAO.findByEmailAndPassword(memberEmail, memberPassword);
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return Optional.empty();
    }

//    전화번호 인증
    @Override
    public String phoneNumberAuthentication(String phonenumber) {
        final int MIN = 1000;
        final int MAX = 9999;
        String randomNumber = Integer.toString((int) (Math.random() * (MAX - MIN + 1)) + MIN);

        phonenumber = phonenumber.replace("-", "");

//		String api_key = "NCSLHZBRFR5JZIGX";
//		String api_secret = "TMWIDCSYTTIWBNNP4PDQFBM2S5T2F8HY";
//		Message coolsms = new Message(api_key, api_secret);
//		// 4 params(to, from, type, text) are mandatory. must be filled
//		HashMap<String, String> params = new HashMap<String, String>();
//		params.put("to", phonenumber);
//		params.put("from", "01076501147");
//		params.put("type", "SMS");
//		params.put("text", "오!스카의 인증번호는 " + randomNumber + " 입니다.");
//		params.put("app_version", "test app 1.2"); // application name and version
//
//		try {
//			JSONObject obj = (JSONObject) coolsms.send(params);
//			System.out.println(obj.toString());
//		} catch (CoolsmsException e) {
//			System.out.println(e.getMessage());
//			System.out.println(e.getCode());
//		}

        return randomNumber;
    }

    //   일반 계정 찾기 ( memberEmail반환 )
    @Override
    public List<String> getGeneralAccounts(String memberName, String memberPhonenumber) {
        return memberDAO.findByMemberNameAndPhonenumber(memberName, memberPhonenumber);
    }

    @Override
    public void setGeneralAccountPassword(String memberPassword, String memberEmail) {
        String encryptedPassword = "";
        final int KEY = 3;
        for (int i = 0; i < memberPassword.length(); i++) {
            encryptedPassword += (char)(memberPassword.charAt(i) * KEY);
        }
        memberDAO.resetPassword(encryptedPassword, memberEmail);
    }
}
