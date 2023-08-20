package com.app.osca.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/study/*")
public class StudyController {

    @GetMapping("/")
    public String studyMain(){
        return "study/study-main";
    }

    @GetMapping("/my-study")
    public String myStudy(){
        return "study/my-study";
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
    public String studyOpen(){
        return "study/study-open";
    }

}
