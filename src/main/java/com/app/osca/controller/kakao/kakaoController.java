//package com.app.osca.controller.kakao;
//
//import com.app.osca.service.member.MemberService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//@RequiredArgsConstructor
//@Slf4j
//@RequestMapping("/kakao")
//public class kakaoController {
//
//    private final MemberService memberService;
//
//    @ResponseBody
//    @GetMapping("/login")
//    public void  kakaoCallback(@RequestParam String code, HttpSession session) throws Exception {
//        log.info(code);
//        String token = kakaoService.getKaKaoAccessToken(code);
//        session.setAttribute("token", token);
////        session.setAttribute("memberId", kakaoService.getKakaoInfo(token));
//        kakaoService.getKakaoInfo(token);
//    }
//
//    @GetMapping("/logout")
//    public void kakaoLogout(HttpSession session){
//        log.info("logout");
//        kakaoService.logoutKakao((String)session.getAttribute("token"));
//        session.invalidate();
//    }
//
//}
