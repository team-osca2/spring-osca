package com.app.osca.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/password/*")
@Controller
public class PasswordController {

    @GetMapping("/change")
    public String changePassword(){
        return "mypage/passwordchange";
    }
}
