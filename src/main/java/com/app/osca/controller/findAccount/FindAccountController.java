package com.app.osca.controller.findAccount;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FindAccountController {
    @RequestMapping("/find-account")
    public String goToFindAccount(){
        return "findAccount/find_account";
    }
}
