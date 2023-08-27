package com.app.osca.controller.mainPage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {
    @RequestMapping("/")
    public String home(Model model){
        model.addAttribute("id", "유희준");
        return "index";
    }
}
