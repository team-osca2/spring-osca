package com.app.osca.controller.fix;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FixController {
    @RequestMapping("/header")
    public String returnHeader(){
        return "fix/header";
    }

    @RequestMapping("/footer")
    public String returnFooter(){
        return "fix/footer";
    }
}
