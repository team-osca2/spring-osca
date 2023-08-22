package com.app.osca.controller.signUp;

import com.app.osca.domain.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/sign-up")
public class SignUpController {

    @GetMapping(value = {"", "/"})
    public String signUpContent(MemberVO memberVO){
        return "signup/signup_content";
    }

    @GetMapping("/email-type")
    public String signUpTypeSelect(){
        return "signup/signup_type";
    }

    @GetMapping("/user-type")
    public String signUpUserTypeSelect(){
        return "signup/signup_user_type";
    }

    //  전화번호 중복검사
    @PostMapping("/check-tel")
    @ResponseBody
    public String checkTel(String phonenumber) { return phonenumber; }
}
