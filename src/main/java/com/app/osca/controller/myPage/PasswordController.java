package com.app.osca.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PasswordController {

    @RequestMapping("/password/change")
    public String changePassword(){
        return "mypage/passwordchange";
    }

}
