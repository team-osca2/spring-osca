package com.app.osca.controller.myPage;

import com.app.osca.service.member.MypageMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/password/*")
public class PasswordController {
    private final MypageMemberService memberService;
    private final HttpSession session;

    //    비밀번호 검사하기: 일치하면 true, 불일치면 false
    @GetMapping("check-password")
    @ResponseBody
    public boolean checkPassword(String memberPassword){
//      이부분 아이디 다 합친 후에 session으로 변경하면 됨!
//      return memberService.checkMemberPassword((Long)session.getAttribute("id")).equals(memberPassword);
        Long memberId = 201L;

        String encryptedPassword = "";
        final int KEY = 3;
        for (int i = 0; i < memberPassword.length(); i++) {
            encryptedPassword += (char)(memberPassword.charAt(i) * KEY);
        }
        return memberService.checkMemberPassword(memberId).equals(encryptedPassword);
    }

    @GetMapping("change")
    public String goToForm(String memberPassword){
            return "mypage/passwordchange";
    }

    //  비밀번호 변경하기
    @PostMapping("change")
    public RedirectView change(String memberPassword,Long id, RedirectAttributes redirectAttributes){
        Long memberId = 201L;

//        Long memberId = (Long)session.getAttribute("id");
        memberService.modifyPassword(memberPassword, memberId);
        return new RedirectView("/logout");
    }
}
