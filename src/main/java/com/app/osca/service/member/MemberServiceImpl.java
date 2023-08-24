package com.app.osca.service.member;

import com.app.osca.dao.CeoDAO;
import com.app.osca.dao.MemberDAO;
import com.app.osca.domain.MemberVO;
import com.app.osca.service.ceo.CeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final CeoService ceoService;

    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return Optional.empty();
    }

    @Override
    public void join(MemberVO memberVO) {

        boolean isGeneralMember = memberVO.getMemberRole() == null;
//      회원번호 생성  Long id = memberMapper.selectMemberSequence();

        Long id = memberDAO.findMemberSequence();
        memberVO.setId(id);

//        랜덤 닉네임 생성
        String[] nickNames = {"사과", "바나나", "배", "포도", "딸기", "오렌지", "파인애플", "자두", "귤", "수박"};
        final long SEQ = memberDAO.findNickNameSequence(), DIV = 10000;
        String nickname = nickNames[(int)(SEQ / DIV)] + (SEQ % DIV);
        memberVO.setMemberNickname(nickname);

//      일반 회원이면 가입, 카페 회원이면 포인트 첫 계정인지에 따라 포인트 증정
        if ( isGeneralMember ) {
            memberDAO.saveGeneral(memberVO);
        } else {
            boolean isFirstCafeAccount = memberDAO.isFirstCafeAccount(memberVO.getMemberPhonenumber());
            memberDAO.saveCafe(memberVO);
            ceoService.joinPoint(id, isFirstCafeAccount);
        }
    }

    @Override
    public Optional<Long> login(String memberId, String memberPassword) {
        return Optional.empty();
    }

    @Override
    public Optional<MemberVO> getMember(Long id) {
        return Optional.empty();
    }

    @Override
    public String checkPhonenumber(String phonenumber) {
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
}
