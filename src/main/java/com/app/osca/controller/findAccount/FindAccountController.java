package com.app.osca.controller.findAccount;

import com.app.osca.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class FindAccountController {

    private final MemberService memberService;

    @GetMapping("/find-account")
    public String goToFindAccount(){
        return "findAccount/find_account";
    }

    @PostMapping("/find-account")
    public RedirectView findMemberEmail(String memberName, String memberPhonenumber){
        memberService.getGeneralAccounts(memberName, memberPhonenumber);
        return new RedirectView("/find-account");
    }

//    이메일에 [비밀번호 변경하기] 버튼 클릭 시 가는 URL
    @GetMapping("/goToResetPasswordPage")
    public String resetPassword(HttpServletRequest request, Model model){
        Cookie[] list = request.getCookies();
        for(Cookie cookie : list) {
            if(cookie.getName().equals("memberEmail")) {
                model.addAttribute("memberEmail", cookie.getValue());
                cookie.setMaxAge(0);
                cookie.setPath("/");
                return "findAccount/reset_password";
            }
        }
        return "index";
    }

//    이메일로 비밀번호 변경 페이지 전송
//    쿠키 설정 memberEmail 로 이메일 설정 완료
    @GetMapping("/reset-password")
    public RedirectView getResetPasswordEmail(String memberEmail, HttpServletResponse response) {
        try {
            memberService.sendPasswordRestLink(memberEmail, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new RedirectView("/");
    }

//    비밀번호 변경
    @PostMapping("/reset-memberPassword")
    public RedirectView resetPassword(String memberEmail, String memberPassword){
        memberService.setGeneralAccountPassword(memberPassword, memberEmail);
        return new RedirectView("index");
    }
}
