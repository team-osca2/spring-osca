package com.app.osca.controller.admin.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/board")
public class AdminBoardController {

    @GetMapping(value = {"", "/"})
    public String getAllBoards(){
        return "admin/board/all";
    }

    @GetMapping("/cafe")
    public void getCafeBoards(){;}

    @GetMapping("/study")
    public void getStudyBoards(){;}

    @GetMapping("/delete")
    public void getDeleteBoards(){;}

    @GetMapping("/reported")
    public void getReportedBoards(){;}
}

