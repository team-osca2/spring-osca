package com.app.osca.controller.admin.member;

import com.app.osca.domain.CeoVO;
import com.app.osca.domain.MemberVO;
import com.app.osca.domain.PaymentVO;
import com.app.osca.domain.dto.AdminPaymentDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.service.admin.AdminMemberService;
import com.app.osca.service.admin.AdminPaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("admin/member")
public class AdminMemberController {
    private final AdminMemberService adminMemberService;
    private final AdminPaymentService adminPaymentService;

    public AdminMemberController(AdminMemberService adminMemberService, AdminPaymentService adminPaymentService) {
        this.adminMemberService = adminMemberService;
        this.adminPaymentService = adminPaymentService;
    }

    @GetMapping(value ={"", "/"})
    public String getAllMembers(Model model, Pagination pagination){
        System.out.println("멤버 에브리 리트스");
        pagination.setTotal(adminMemberService.getTotalMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getList(pagination);
        model.addAttribute("users",userList);
        return "admin/member/list";
    }

    @GetMapping(value ={"/user"})
    public String getStudyMembers (Model model, Pagination pagination){
        System.out.println("스터디 멤버 왔아");
        pagination.setTotal(adminMemberService.getTotalStudyMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getUserList(pagination);
        model.addAttribute("users",userList);
        return "admin/member/user";
    }

    @GetMapping(value ={"/cafe"})
    public String getCeoMembers (Model model, Pagination pagination){
        pagination.setTotal(adminMemberService.getTotalCeoMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getCeoList(pagination);
        model.addAttribute("users",userList);
        return "admin/member/cafe";
    }

    @GetMapping(value ={"/reported"})
    public String getReported (Model model, Pagination pagination){
        pagination.setTotal(adminMemberService.getTotalReportedMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getReportedUser(pagination);
        model.addAttribute("users",userList);
        return "admin/member/reported";
    }

    @GetMapping(value ={"/payment"})
    public String  getList (Model model, Pagination pagination){
        pagination.setTotal(adminPaymentService.getTotalNum());
        pagination.progress();
        List<AdminPaymentDTO> payList = adminPaymentService.getList(pagination);
        model.addAttribute("payLists", payList);
        return "admin/member/payment";
    }


    @GetMapping(value ={"/suspended"})
    public String getSuspended (Model model, Pagination pagination){
        pagination.setTotal(adminMemberService.getTotalSuspendedMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getBlockedUser(pagination);
        model.addAttribute("users",userList);
        return "admin/member/suspended";
    }


    @PutMapping("/blockUsers")
    public ResponseEntity<String> blockUsers(@RequestBody Long id) {
        try {
            adminMemberService.block(id);
            return new ResponseEntity<>("성공적으로 삭제 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/restoreUsers")
    public ResponseEntity<String> restoreUsers(@RequestBody Long id) {
        try {
            adminMemberService.restore(id);
            return new ResponseEntity<>("성공적으로 복구 되었습니다", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
