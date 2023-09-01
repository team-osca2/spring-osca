package com.app.osca.controller.myPage;

import com.app.osca.domain.GeneralVO;
import com.app.osca.domain.MemberJobVO;
import com.app.osca.domain.MemberSkillVO;
import com.app.osca.domain.dto.CafeScrapDTO;
import com.app.osca.domain.dto.MemberSkillDTO;
import com.app.osca.domain.dto.StudyScrapDTO;
import com.app.osca.service.cafeScrap.MypageCafeScrapService;
import com.app.osca.service.general.MypageGeneralService;
import com.app.osca.service.member.MypageMemberService;
import com.app.osca.service.memberJob.MypageMemberJobService;
import com.app.osca.service.memberSkill.MypageMemberSkillService;
import com.app.osca.service.studyScrapService.MypageStudyScrapSercvice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/mypage/*")
@RequiredArgsConstructor
@Slf4j
public class MyPageController {
    private final MypageMemberService memberService;
    private final MypageMemberSkillService memberSkillService;
    private final MypageGeneralService generalService;
    private final MypageMemberJobService memberJobService;
    private final MypageStudyScrapSercvice studyScrapSercvice;
    private final MypageCafeScrapService cafeScrapService;
    private final HttpSession session;

    @GetMapping("/favourites")
    public void goToSetting(Model model) {
//      로그인 부터 테스트 할때는 이 코드로 사용하면 됨
//      model.addAttribute("memberNickname",memberService.getMemberInfo((Long)session.getAttribute("id")).get().getMemberNickname());
        model.addAttribute("memberNickname", memberService.getMemberInfo(1L).get().getMemberNickname());

        List<StudyScrapDTO> studyList = studyScrapSercvice.getScrapList(1L);
        model.addAttribute("studyLists", studyList);

        List<CafeScrapDTO> cafeList = cafeScrapService.getList(1L);
        model.addAttribute("cafeLists", cafeList);
    }

    @GetMapping("/point-charge")
    public void goToPointCharge(Model model) {
        model.addAttribute("memberNickname", memberService.getMemberInfo(1L).get().getMemberNickname());
    }

    @GetMapping("/payment-api")
    public void goToPaymentAPI() {
        ;
    }

    //    ================== 회원 글 등록 및 수정하는 부분 ==================  //
//  =================== 회원 정보 뿌리기 =================== //
    @GetMapping("/edit-myprofile")
    public void goToEditProfile(Model model, GeneralVO generalVO, MemberSkillVO memberSkillVO, MemberJobVO memberJobVO) {
        model.addAttribute("memberNickname", memberService.getMemberInfo(193L).get().getMemberNickname());
        model.addAttribute("general", generalService.getGeneralInfo(193L).get());
        model.addAttribute("job", memberJobService.getByMemberId(193L).get());

        List<Long> skillIds = new ArrayList<>();
        List<MemberSkillDTO> skillList = memberSkillService.getList(193L);

        for (MemberSkillDTO skill : skillList) {
            skillIds.add(skill.getSkillListId());
        }

        model.addAttribute("skillIds", skillIds);
    }


    private boolean skillExists(MemberSkillVO memberSkillVO) {
        int count = memberSkillService.getByMemberIdAndSkillListId(memberSkillVO.getSkillListId(), memberSkillVO.getMemberId());
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @PostMapping("/edit-myprofile")
    public RedirectView processEditForm(GeneralVO generalVO, MemberSkillVO memberSkillVO,
                                        @RequestParam List<Long> skillListIds,
                                        MemberJobVO memberJobVO) {
        Long memberId = 193L;

        generalVO.setMemberId(memberId);
        if (generalService.getGeneralInfo(memberId).isPresent()) {
            generalService.modify(generalVO); // 이미 데이터가 있는 경우 수정
        } else {
            generalService.write(generalVO); // 데이터가 없는 경우 새로 생성
        }

        memberJobVO.setMemberId(memberId);
        memberJobVO.setJobCategoryId(1L); // 수정 필요
        if (memberJobService.getByMemberId(memberId).isPresent()) {
            memberJobService.modifyJobId(memberJobVO); // 이미 데이터가 있는 경우 수정
        } else {
            memberJobService.write(memberJobVO); // 데이터가 없는 경우 새로 생성
        }

        skillListIds.forEach(skillListId -> {
            MemberSkillVO memberSkillVO1 = new MemberSkillVO();
            memberSkillVO1.setSkillListId(skillListId);
            memberSkillVO1.setMemberId(memberId);

            // 이미 해당 스킬이 존재하는지 검사
            if (skillExists(memberSkillVO1)) {
                // 해당 멤버의 스킬이 존재하지 않으면 insert
                memberSkillService.write(skillListId, memberId);
            }
        });


        return new RedirectView("/user/93");
    }

//    @PostMapping("remove-skill")
//    @ResponseBody
//    public void deleteMemberSkillId(@PathVariable Long skillListId, Long memberId) {
//        memberSkillService.removeMemberSkillId(skillListId,memberId);
//    }
}