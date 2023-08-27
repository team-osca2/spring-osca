package com.app.osca.controller.kakao;


import com.app.osca.service.member.KakaoService;
import com.app.osca.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/kakao/*")
public class kakaoController {

    private final MemberService memberService;
    private final KakaoService kakaoService;

    @ResponseBody
    @GetMapping("/login")
    public RedirectView kakaoCallback(@RequestParam String code, HttpSession session) throws Exception {
        log.info(code);
        String memberEmail = "";
        String token = kakaoService.getKaKaoAccessToken(code);
        session.setAttribute("token", token);
        memberEmail = kakaoService.getKakaoInfo(token);
        if ( !memberEmail.equals("") ) {
            Long id = memberService.getSequence();
            if ( !memberService.checkId(memberEmail).isPresent() ) {
                memberService.joinKakaoMember(id, memberEmail);
            }
            session.setAttribute("id", id);
        }
        return new RedirectView("/");
    }

    @GetMapping("/logout")
    public RedirectView kakaoLogout(HttpSession session){
        log.info("logout");
        kakaoService.logoutKakao((String)session.getAttribute("token"));
        session.invalidate();
        return new RedirectView("/");
    }

}
