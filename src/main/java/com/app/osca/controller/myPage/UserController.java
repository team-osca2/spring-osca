package com.app.osca.controller.myPage;

import com.app.osca.service.general.MypageGeneralService;
import com.app.osca.service.member.MypageMemberService;
import com.app.osca.service.memberJob.MypageMemberJobService;
import com.app.osca.service.memberSkill.MypageMemberSkillService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
    private final MypageMemberService memberService;
    private final MypageGeneralService generalService;
    private final MypageMemberJobService memberJobService;
    private final MypageMemberSkillService memberSkillService;
    private final HttpSession session;

    @RequestMapping("/user/{id}")
    public String goToMyPage(@PathVariable String id, Model model) {
        model.addAttribute("memberNickName",memberService.getMemberInfo(1L).get().getMemberNickname());
        model.addAttribute("general",generalService.getGeneralInfo(1L).get());
        model.addAttribute("memberJob",memberJobService.getByMemberId(1L).get().getJob());
        model.addAttribute("skills", memberSkillService.getList(1L));

//      세션에서 가져온 아이디와 일치하는 경우
        return "mypage/" + (id.equals("dbgmlwns") ? "mypage" : "profile-page");
    }

}
