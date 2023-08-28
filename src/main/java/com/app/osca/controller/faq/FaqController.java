package com.app.osca.controller.faq;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/FAQ/*")
@RequiredArgsConstructor
public class FaqController {
    @RequestMapping("FAQ-detail")
    public void goToFaqDetail(){;}

    @RequestMapping("FAQ-list")
    public void goToFaqList(){;}

    @RequestMapping("FAQ-main")
    public void goToFaqMain(){;}

    @RequestMapping("FAQ-post")
    public void goToFaqPost(){;}
}

