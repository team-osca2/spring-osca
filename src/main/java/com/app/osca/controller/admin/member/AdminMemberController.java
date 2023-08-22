package com.app.osca.controller.admin.member;

import com.app.osca.domain.CeoVO;
import com.app.osca.domain.MemberVO;
import com.app.osca.domain.PaymentVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/member")
public class AdminMemberController {
    @GetMapping(value ={"", "/"})
    public String getAllMembers(MemberVO memberVO){
        return "admin/member/list";
    }

    @GetMapping("/add-point")
    public void AddPoint(CeoVO ceoVO){;}

    @GetMapping("/payment")
    public void getPaymentList(PaymentVO paymentVO){;}
}
