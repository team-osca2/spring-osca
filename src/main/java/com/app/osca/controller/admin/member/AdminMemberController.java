package com.app.osca.controller.admin.member;

import com.app.osca.domain.CeoVO;
import com.app.osca.domain.MemberVO;
import com.app.osca.domain.PaymentVO;
import com.app.osca.domain.dto.AdminStudyDTO;
import com.app.osca.domain.paging.Pagination;
import com.app.osca.service.admin.AdminMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("admin/member")
public class AdminMemberController {
    private final AdminMemberService adminMemberService;

    public AdminMemberController(AdminMemberService adminMemberService) {
        this.adminMemberService = adminMemberService;
    }

    @GetMapping(value ={"", "/"})
    public String getAllMembers(Model model, Pagination pagination){
        pagination.setTotal(adminMemberService.getTotalMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getList(pagination);
        model.addAttribute("users",userList);
        return "admin/member/list";
    }

    @GetMapping(value ={"/user"})
    public String getStudyMembers (Model model, Pagination pagination){
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

    @GetMapping(value ={"/suspended"})
    public String getSuspended (Model model, Pagination pagination){
        pagination.setTotal(adminMemberService.getTotalSuspendedMembers());
        pagination.progress();
        List<MemberVO> userList = adminMemberService.getBlockedUser(pagination);
        model.addAttribute("users",userList);
        return "admin/member/suspended";
    }

    @GetMapping("/add-point")
    public void AddPoint(CeoVO ceoVO){;}

    @GetMapping("/payment")
    public void getPaymentList(PaymentVO paymentVO){;}
}
