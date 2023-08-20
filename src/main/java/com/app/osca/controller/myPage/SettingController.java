package com.app.osca.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setting/*")
public class SettingController {

    @GetMapping("/")
    public String goToSetting(){
        return "mypage/settings";
    }

    @GetMapping("/modify")
    public String editProfile(){
        return "mypage/edit-myprofile";
    }

    @GetMapping("/withdraw")
    public String withdrawProfile(){
        return "mypage/remove-account";
    }


}
