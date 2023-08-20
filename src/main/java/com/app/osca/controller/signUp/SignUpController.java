package com.app.osca.controller.signUp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signUp/*")
public class SignUpController {

    @GetMapping("/signUp-type-select")
    public String signUpTypeSelect(){
        return "signup/signup_type";
    }

    @GetMapping("/signUp-user-type")
    public String signUpUserTypeSelect(){
        return "signup/signup_user_type";
    }

    @GetMapping("/signUp-content")
    public String signUpContent(){
        return "signup/signup_content";
    }


}
