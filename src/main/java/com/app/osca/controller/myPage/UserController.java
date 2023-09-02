package com.app.osca.controller.myPage;

import com.app.osca.domain.GeneralVO;
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
        Long memberId = 193L;
        model.addAttribute("memberNickName",memberService.getMemberInfo(201L).get().getMemberNickname());
//        GeneralVO generalVO = new GeneralVO(2L,"네모대학교","카카오", "", "", "안녕하세요! 신인 웹 개발자입니다. 반갑습니다.", "개발자", "3000만원");
        model.addAttribute("general",generalService.getGeneralInfo(memberId).get());
        model.addAttribute("memberJob",memberJobService.getByMemberId(memberId).get().getJob());
        model.addAttribute("skills", memberSkillService.getList(memberId));

//      세션에서 가져온 아이디와 일치하는 경우
        return "mypage/" + (id.equals("dbgmlwns") ? "mypage" : "profile-page");
    }

}
