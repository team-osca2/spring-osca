package com.app.osca.controller.introduction;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IntroductionController {
    @RequestMapping("/introduction")
    public String goToIntro(){
        return "introduction/introduction";
    }
}
