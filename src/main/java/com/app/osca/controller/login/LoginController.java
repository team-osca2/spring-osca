package com.app.osca.controller.login;

import com.app.osca.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class LoginController {

    private final MemberService memberService;

//    로그인
    @PostMapping("/login")
    public RedirectView login(String memberEmail, String memberPassword, HttpSession session, RedirectAttributes redirectAttributes) {
        final Optional<Long> foundMember = memberService.login(memberEmail, memberPassword);

        if(foundMember.isPresent()){
            session.setAttribute("id", foundMember.get());
            redirectAttributes.addFlashAttribute("login", "logined-header");
            return new RedirectView("/");
        }

        redirectAttributes.addFlashAttribute("login", "unlogined-header");
        return new RedirectView("/");
    }

//    로그아웃
    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();
        return new RedirectView("/");
    }

}
