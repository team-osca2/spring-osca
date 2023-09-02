package com.app.osca.controller.admin.faq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/faq")
public class AdminFaqController {

    @GetMapping(value = {"", "/"})
    public String getAllFaq() {
        return "admin/faq/list";
    }

    @GetMapping("/write")
    public String writeFaq() {
        return "admin/faq/write";
    }
}