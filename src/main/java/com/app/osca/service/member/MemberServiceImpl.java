package com.app.osca.service.member;

import com.app.osca.domain.MemberVO;
import java.util.Optional;

public class MemberServiceImpl implements MemberService {
    @Override
    public Optional<MemberVO> checkId(String memberId) {
        return Optional.empty();
    }

    @Override
    public void join(MemberVO memberVO) {

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
    public String phonenumberAuthentication(String phonenumber) {
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
