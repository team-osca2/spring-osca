package com.app.osca.controller.mainPage;

import com.app.osca.domain.ImageVO;
import com.app.osca.domain.dto.main.MainStudyDTO;
import com.app.osca.service.mainpage.MainPageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@Slf4j
public class MainController {

    private final MainPageService mainPageService;

    @RequestMapping("/")
    public String home(Model model, HttpSession session){
        Long id = (Long) session.getAttribute("id");
        model.addAttribute("mainStudyList", mainPageService.getMainStudyList());
        model.addAttribute("mainCafeList", mainPageService.getMainCafeList());
        if ( id != null ) {
            mainPageService.getMemberProfile(id).ifPresent((profile) -> {
                model.addAttribute("memberProfile", profile);
            });
        }
        return "index";
    }

    @RequestMapping("/checkAdmin")
    @ResponseBody
    public String aouthAdmin(){
        final String AOUTH_CODE = "89HASNRJ54AA+/admin/member";
        return AOUTH_CODE;
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] display(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/", fileName));
    }

}
