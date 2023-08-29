package com.app.osca.controller.myPage;

import com.app.osca.service.cafe.MypageCafeService;
import com.app.osca.service.member.MypageMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/setting")
@RequiredArgsConstructor
@Slf4j
public class SettingController {
    private final MypageMemberService memberService;
    private final MypageCafeService cafeService;

    //  =================== 회원 정보 뿌리기 =================== //
    @GetMapping(value = {"", "/"})
    public String goToSetting(Model model) {
        model.addAttribute("member",memberService.getMemberInfo(3L).get());
        model.addAttribute("cafeBusinessNumber",cafeService.getBusinessNum(3L));
        return "mypage/settings";
    }

    //  =================== 닉네임 변경하기 =================== //
    //    닉네임 중복 검사하기: 1이면 중복, 0이면 사용 가능
    @GetMapping("/check-nickname/{memberNickname}")
    @ResponseBody
    public int checkNickname(@PathVariable String memberNickname){
        return memberService.checkNickname(memberNickname);
    }

    @GetMapping("changeMemberNickname")
    public String goToMemberNickName(String memberNickname){
        return "mypage/settings";
    }

    @PostMapping("changeMemberNickname")
    public RedirectView change(String memberNickname, Long id){
        // 세션에서 가져온 아이디로 수정
        memberService.modifyMemberNickname(memberNickname,3L);
        return new RedirectView("/setting/");
    }

    //  =================== 휴대폰 번호 변경하기 =================== //
    @GetMapping("change-phonenumber")
    public String goToMemberPhoneNumber(String memberPhoneNumber){
        return "mypage/settings";
    }

    @PostMapping("change-phonenumber")
    public RedirectView changePhoneNumber(String memberPhonenumber, Long id){
        // 세션에서 가져온 아이디로 수정
        memberService.modifyPhonenumber(memberPhonenumber,3L);
        return new RedirectView("/setting/");
    }

    //  =================== 사업자 번호 변경하기 =================== //
    @GetMapping("changeBusinessNumber")
    public String goToBusinessNumber(String cafeBusinessNumber){
        return "mypage/settings";
    }

    @PostMapping("changeBusinessNumber")
    public RedirectView changeBusinessNumber(String cafeBusinessNumber, Long memberId){
        // 세션에서 가져온 아이디로 수정
        cafeService.modifyBusinessNum(cafeBusinessNumber,3L);
        return new RedirectView("/setting/");
    }


    //  ===================  회원 탈퇴하기 =================== //
    @GetMapping("/withdraw")
    public String withdrawProfile(){
        return "mypage/remove-account";
    }

//    @GetMapping("/withdraw")
//    public RedirectView remove(Long id, HttpSession session){
//        memberService.remove(93L);
//        session.invalidate();
//        return new RedirectView("/index");
//    }
}