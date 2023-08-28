package com.app.osca.controller.admin.board;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.service.admin.AdminCafeAdService;
import com.app.osca.service.admin.AdminStudyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/board")
public class AdminBoardController {
    private final AdminCafeAdService adminCafeAdService;
    private final AdminStudyService adminStudyService;

    public AdminBoardController(AdminCafeAdService adminCafeAdService, AdminStudyService adminStudyService) {
        this.adminCafeAdService = adminCafeAdService;
        this.adminStudyService = adminStudyService;
    }
    @GetMapping(value = {"", "/"})
    public String getAllBoards(Model model, Pagination pagination){
        pagination.setTotal(adminStudyService.getTotalStudyAndCafe());
        pagination.progress();
        List<AdminStudyDTO> studyList = adminStudyService.getListStudyNCafe(pagination);
        model.addAttribute("posts", studyList);
        return "admin/board/all";
    }

    @GetMapping("/cafe")
    public String getCafeBoards(Model model, Pagination pagination){
        pagination.setTotal(adminCafeAdService.getTotalCafe());
        pagination.progress();
        List<AdminCafeAdDTO> cafeList = adminCafeAdService.getList(pagination);
        model.addAttribute("posts", cafeList);
        return "admin/board/cafe";
    }

    @GetMapping("/study")
    public String getStudyBoards(Model model, Pagination pagination) {
        pagination.setTotal(adminStudyService.getTotalStudy());
        pagination.progress();
        List<AdminStudyDTO> studyList = adminStudyService.getList(pagination);
        model.addAttribute("posts", studyList);
        return "admin/board/study";
    }

    @GetMapping("/delete")
    public String getDeleteBoards(Model model, Pagination pagination){
        pagination.setTotal(adminStudyService.getTotalDeletedStudyAndCafe());
        pagination.progress();
        List<AdminStudyDTO> allList = adminStudyService.getListDeleted(pagination);
        model.addAttribute("posts", allList);
        return "admin/board/delete";
    }


    @GetMapping("/reported")
    public String getReportedBoards(Model model, Pagination pagination){
        pagination.setTotal(adminStudyService.getTotalBlockedStudyAndCafe());
        pagination.progress();
        List<AdminStudyDTO> studyList = adminStudyService.getListReported(pagination);
        model.addAttribute("posts", studyList);
        return "admin/board/reported";
    }


}

