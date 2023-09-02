package com.app.osca.controller.admin.reply;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.dto.AdminReplyDTO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.service.admin.AdminReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/reply")
public class AdminReplyController {
    private final AdminReplyService adminReplyService;

    public AdminReplyController(AdminReplyService adminReplyService) {
        this.adminReplyService = adminReplyService;
    }

    @GetMapping(value = {"", "/"})
    public String getAllReplies(Model model, Pagination pagination){
        pagination.setTotal(adminReplyService.getCountOfReplies());
        pagination.progress();
        List <AdminReplyDTO> replyList = adminReplyService.getList(pagination);
        model.addAttribute("replys", replyList);
        return "admin/reply/list";
    }

    @GetMapping("/reported")
    public String getReportedReplies(Model model, Pagination pagination){
        pagination.setTotal(adminReplyService.getCountOfReportedReplies());
        pagination.progress();
        List <AdminReplyDTO> replyList = adminReplyService.getListReported(pagination);
        model.addAttribute("replys", replyList);
        return "admin/reply/reported";
    }

    @GetMapping("/deleted")
    public String getDeletedReplies(Model model, Pagination pagination){
        pagination.setTotal(adminReplyService.getCountOfDeletedReplies());
        pagination.progress();
        List <AdminReplyDTO> replyList = adminReplyService.getListDeleted(pagination);
        model.addAttribute("replys", replyList);
        return "admin/reply/deleted";
    }
}
