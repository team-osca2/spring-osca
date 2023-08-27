package com.app.osca.service.member;

import com.app.osca.dao.MemberDAO;
import com.app.osca.domain.MemberVO;
import com.app.osca.service.ceo.CeoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberDAO memberDAO;
    private final CeoService ceoService;
//    private final JavaMailSender javaMailSender;

    @Override
    public Long getSequence() {
        return memberDAO.findMemberSequence();
    }

    //    아이디 중복검사
    @Override
    public Optional<String> checkId(String memberEmail) {
        return memberDAO.findByEmail(memberEmail);
    }

//    회원가입                              완료
    @Override
    public String join(MemberVO memberVO) {

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

        return nickname;

    }

//    로그인                                     완료
    @Override
    public Optional<Long> login(String memberEmail, String memberPassword) {
        final int KEY = 3;
        String encryptedPassword = "";
        for (int i = 0; i < memberPassword.length(); i++) {
            encryptedPassword += (char)(memberPassword.charAt(i) * KEY);
        }
        return memberDAO.findByEmailAndPassword(memberEmail, encryptedPassword);
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

		String api_key = "NCSF9OW2I1LDLV3Y";
		String api_secret = "MRF0MFCTQNMO3EWFGFTF5RDWWZNLKJ7S";
		Message coolsms = new Message(api_key, api_secret);
		// 4 params(to, from, type, text) are mandatory. must be filled
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("to", phonenumber);
		params.put("from", "01054911228");
		params.put("type", "SMS");
		params.put("text", "오!스카의 인증번호는 " + randomNumber + " 입니다.");
		params.put("app_version", "test app 2.2"); // application name and version

		try {
			coolsms.send(params);
		} catch (CoolsmsException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCode());
		}

        return randomNumber;
    }

    //   일반 계정 찾기 ( memberEmail반환 )
    @Override
    public void getGeneralAccounts(String memberName, String memberPhonenumber) {
        List<String> accountList = memberDAO.findByMemberNameAndPhonenumber(memberName, memberPhonenumber);
        String noAccountMsg = "오!스카에 가입된 계정이 없습니다.";
        String allAccountMsg = "오!스카에 가입된 계정은" + accountList.toString() + "입니다.";
        String api_key = "NCSF9OW2I1LDLV3Y";
        String api_secret = "MRF0MFCTQNMO3EWFGFTF5RDWWZNLKJ7S";
        Message coolsms = new Message(api_key, api_secret);
        // 4 params(to, from, type, text) are mandatory. must be filled
        HashMap<String, String> params = new HashMap<String, String>();
        params.put("to", memberPhonenumber);
        params.put("from", "01054911228");
        params.put("type", "SMS");
        if ( accountList.isEmpty() ) {
            params.put("text", noAccountMsg);
        } else {
            params.put("text", allAccountMsg);
        }
        params.put("app_version", "test app 2.2"); // application name and version

        try {
            coolsms.send(params);
        } catch (CoolsmsException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCode());
        }
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

//    비밀번호 재설정 링크 발송
    @Override
    public void sendPasswordRestLink(String memberEmail, HttpServletResponse response) throws IOException, ServletException {

        // 메일 인코딩
        final String bodyEncoding = "UTF-8"; // 콘텐츠 인코딩

        // 원하는 메일 제목 작성
        String subject = "비밀번호 재설정";

        String fromEmail = "cyberkdy2@gmail.com";
        String fromUsername = "오!스카";

        String toEmail = memberEmail; // 콤마(,)로 여러개 나열

        final String username = "cyberkdy2@gmail.com";
        final String password = "qnyfmgktsqedxnea";

        String html = null;
        StringBuffer sb = new StringBuffer(1100);
        sb.append("<center><table style=\"max-width: 630px; height:100%;margin:0;padding:0;width:100%;color: #303441!important;\">")
                .append("<tbody><tr><td><div style=\"margin: 40px auto 0 auto;\"><div>")
                .append("<a href=\"#\" style=\"mso-line--rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%;text-decoration: none;\" rel=\"noreferrer noopener\" target=\"_blank\">")
                .append("</a><div style=\"margin-top: 12px!important;color: #303441!important;font-size: 26px!important;font-weight: 700!important;\">")
                .append("비밀번호 변경 안내</div></div><div style=\"margin-top:16px;\"><div style=\"font-size: 16px;\"> 안녕하세요, 회원님!")
                .append("<br>비밀번호 재설정 버튼을 클릭하고 새로운 비밀번호로 변경해 주세요.</div></div><div style=\"width: 248px;\">")
                .append("<button type=\"submit\" style=\"font-weight: 500; margin-top: 24px; width: 248px; height: 52px; border-radius: 4px; background-color: #FFD400; padding: 14px; font-size: 16px; border: none;\">")
                .append("<a style=\"color: #303441; text-decoration: none;\" href=\"http://localhost:10000/goToResetPasswordPage")
//                .append(memberEmail)
                .append("\" rel=\"noreferrer noopener\" target=\"_blank\">비밀번호 재설정</a>")
                .append("</button></div></div><div style=\"margin: 80px 0 16px 0; color: #303441; font-size: 14px\">")
                .append("<span style=\"font-weight: 700;\">꼭 확인해 주세요!</span><ul style=\"margin: 0;padding: 0; list-style: none; text-indent: -15px;\"><li style=\"margin: 0;\">")
                .append("· 비밀번호 재설정 링크는 메일 수신 후 3시간 동안만 유효합니다.")
                .append("</li><li style=\"margin: 0;\">· 본인의 신청이 아닌 경우, 고객센터(osca.com)로 문의해 주세요.</li></ul>")
                .append("</div><div style=\"color: #9A9BA7;font-size: 13px;padding-top: 16px;border-top: 1px solid #F2F3F7;;margin: 0 auto 20px auto;\">")
                .append("<div>본 메일은 발신 전용으로 회신되지 않습니다.<br> 궁금하신 사항은 FAQ를 참고해 주세요!</div><div style=\"margin-top: 20px;\">")
                .append("고객센터 1234-5678 | osca.com</div><div>(주) 오!스카 | 대한민국 어딘가 </div><div>Copyright © osca Inc. All rights reserved")
                .append("</div></div></td></tr></tbody></table></center>");

        html = sb.toString();

        // 메일 옵션 설정
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");

        try {
            // 메일 서버 인증 계정 설정
            Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            };

            // 메일 세션 생성
            Session session = Session.getDefaultInstance(props, auth);

            // 메일 송/수신 옵션 설정
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail, fromUsername));
            message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(toEmail, false));
            message.setSubject(subject);
            message.setSentDate(new Date());

            // 메일 콘텐츠 설정
            Multipart mParts = new MimeMultipart();
            MimeBodyPart mTextPart = new MimeBodyPart();
            MimeBodyPart mFilePart = null;

            // 메일 콘텐츠 - 내용
            mTextPart.setText(html, bodyEncoding, "html");
            mParts.addBodyPart(mTextPart);

            // 메일 콘텐츠 설정
            message.setContent(mParts);

            // 메일 발송
            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }

//      쿠키 생성
        Cookie cookie = new Cookie("memberEmail", memberEmail);
        cookie.setDomain("localhost");
        cookie.setPath("/goToResetPasswordPage");
        // 3 시간동안 저장
        cookie.setMaxAge(60 * 60 * 60 * 60 * 3);
        cookie.setSecure(true);
        response.addCookie(cookie);

    }

    @Override
    public void joinKakaoMember(Long id, String memberEmail) {

//        랜덤 닉네임 생성
        String[] nickNames = {"사과", "바나나", "배", "포도", "딸기", "오렌지", "파인애플", "자두", "귤", "수박"};
        final long SEQ = memberDAO.findNickNameSequence(), DIV = 10000;
        String nickname = nickNames[(int)(SEQ / DIV)] + (SEQ % DIV);

        memberDAO.saveKakaoMember(id, nickname, memberEmail);
    }


}
