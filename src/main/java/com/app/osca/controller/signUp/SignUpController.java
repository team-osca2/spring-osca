package com.app.osca.controller.signUp;

import com.app.osca.domain.MemberVO;
import com.app.osca.service.ceo.CeoService;
import com.app.osca.service.member.MemberService;
import com.app.osca.service.member.MemberServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@RequiredArgsConstructor
@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    private final MemberService memberService;

    @GetMapping(value = {"", "/"})
    public String signUpContent(MemberVO memberVO, String role, Model model){
        model.addAttribute("role", role);
        return "signup/signup_content";
    }

    @PostMapping(value = {"", "/"})
    public RedirectView receiveSignUpContent(MemberVO memberVO, RedirectAttributes redirectAttributes){
        String memberNickname = memberService.join(memberVO);
        redirectAttributes.addFlashAttribute("memberNickname", memberNickname);
        return new RedirectView("/sign-up/result-page");
    }

    @GetMapping("/email-type")
    public String signUpTypeSelect(){
        return "signup/signup_type";
    }

    @GetMapping("/user-type")
    public String signUpUserTypeSelect(String role, Model model){ return "signup/signup_user_type"; }

//      전화번호 중복검사
    @PostMapping("/check-tel")
    @ResponseBody
    public String checkTel(String phonenumber) {
        return memberService.phoneNumberAuthentication(phonenumber);
    }

//    회원가입 완료 페이지
    @GetMapping("/result-page")
    public String goToResultPage(String memberNickname) {
        return "signup/signup_result";
    }


}
