package com.app.osca.cafe;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.TicketVO;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdImagesDTO;
import com.app.osca.service.cafeAd.CafeAdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/cafe")
@RequiredArgsConstructor
@Slf4j
public class CafeController {

    final private CafeAdService cafeAdService;

    @GetMapping(value = {"", "/"})
    public String goToCafeMain(CafeAdImagesDTO cafeAdImagesDTO){
        return "/cafe/cafe_main";
    }

    @GetMapping("/my-cafe")
    public void goToMyCafeList(Model model){
        model.addAttribute("myCafeList", "sdf");
    }

    @GetMapping("/write")
    public void goToCafeWrite(Model model,CafeVO cafeVO){
        ;
    }

    @GetMapping("/detail/{id}")
    public String goToDetail(Model model, @PathVariable Long id){
        Optional<CafeAdDetailDTO> cafe = cafeAdService.getOneCafeAd(id);
        if(cafe.isEmpty()){
            return "index";
        }
        model.addAttribute("cafe", cafe.get());
        return "temp/cafeDetail";
    }

    @GetMapping("/ticket-purchase")
    public String goToTicket(TicketVO ticketVO){
        return "ticket/ticket";
    }

}
