package com.app.osca.controller.admin.reply;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/reply")
public class AdminReplyController {
    @GetMapping(value = {"", "/"})
    public String getAllReplies(){
        return "admin/reply/list";
    }
}
