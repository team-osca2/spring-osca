package com.app.osca.controller.admin.board;

import com.app.osca.domain.dto.AdminCafeAdDTO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.service.admin.AdminCafeAdService;
import com.app.osca.service.admin.AdminReplyService;
import com.app.osca.service.admin.AdminStudyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/board")
public class AdminBoardController {
    private final AdminCafeAdService adminCafeAdService;
    private final AdminStudyService adminStudyService;
    private final AdminReplyService adminReplyService;
    public AdminBoardController(AdminCafeAdService adminCafeAdService, AdminStudyService adminStudyService, AdminReplyService adminReplyService) {
        this.adminCafeAdService = adminCafeAdService;
        this.adminStudyService = adminStudyService;
        this.adminReplyService = adminReplyService;
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


    @PutMapping("/cafeBlockPost")
    public ResponseEntity<String> removeCafeBoards(@RequestBody Long id) {
        try {
            adminStudyService.remove(id);
            return new ResponseEntity<>("성공적으로 삭제 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/studyBlockPost")
    public ResponseEntity<String> removeStudyBoards(@RequestBody Long id) {
        try {
            adminCafeAdService.remove(id);
            return new ResponseEntity<>("성공적으로 삭제 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/studyRestorePost")
    public ResponseEntity<String> restoreStudyBoards(@RequestBody Long id) {
        try {
            adminStudyService.recover(id);
            return new ResponseEntity<>("성공적으로 복구 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cafeRestorePost")
    public ResponseEntity<String> restoreCafeBoards(@RequestBody Long id) {
        try {
            adminCafeAdService.restore(id);
            return new ResponseEntity<>("성공적으로 복구 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/deleteReply")
    public ResponseEntity<String> removeReply(@RequestBody Long id) {
        try {
            adminReplyService.delete(id);
            return new ResponseEntity<>("성공적으로 삭제 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/restoreReply")
    public ResponseEntity<String> restoreReply(@RequestBody Long id) {
        try {
            adminReplyService.recover(id);
            return new ResponseEntity<>("성공적으로 복구 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

