package com.app.osca.controller.study;

import com.app.osca.domain.StudyVO;
import com.app.osca.service.study.StudyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/study")
@RequiredArgsConstructor
public class StudyController {

    final private StudyService studyService;

    @GetMapping(value = {"", "/"})
    public String studyMain(){
        return "study/study-main";
    }

    @GetMapping("/my-study")
    public void myStudy(){
        ;
    }

    @GetMapping("/applicant")
    public String studyCheck(){
        return "study/study-check";
    }

    @GetMapping("/detail")
    public String studyDetail(){
        return "study/study-detail";
    }

    @GetMapping("/write")
    public String studyOpen(StudyVO studyVO){
        return "study/study-open";
    }

    @PostMapping("/write")
    public RedirectView saveStudy(StudyVO studyVO){
        studyVO.setMemberId(1L);
        studyService.join(studyVO);
        return new RedirectView("/study/detail");
    }

}
