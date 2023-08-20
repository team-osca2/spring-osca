package com.app.osca.controller.myPage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class UserController {

    @RequestMapping("/user/{id}")
    public String goToMyPage(@PathVariable String id) {
        log.info(id);
        return "mypage/" + (id.equals("dbgmlwns") ? "mypage" : "profile-page");
    }

}
