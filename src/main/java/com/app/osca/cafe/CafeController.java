package com.app.osca.cafe;

import com.app.osca.domain.CafeVO;
import com.app.osca.domain.TicketVO;
import com.app.osca.domain.UpdateStateEnum;
import com.app.osca.domain.dto.cafeAd.CafeAdDetailDTO;
import com.app.osca.domain.dto.cafeAd.CafeAdImagesDTO;
import com.app.osca.domain.dto.ticket.TicketDTO;
import com.app.osca.domain.paging.Criteria;
import com.app.osca.domain.paging.PageDTO;
import com.app.osca.service.cafeAd.CafeAdService;
import com.app.osca.service.ticket.TicketService.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
@RequestMapping("/cafe")
@RequiredArgsConstructor
@Slf4j
public class CafeController {

    final private CafeAdService cafeAdService;
    final private TicketService ticketService;

    @GetMapping(value = {"", "/"})
    public String goToCafeMain(Model model, Criteria criteria){
//        criteria.setAmount(8);
//        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, 20, 8));
//        model.addAttribute("cafeAds", cafeAdService.getCafeAdList(criteria));
        return "/cafe/cafe_main";
    }

    @GetMapping("/my-cafe")
    public void goToMyCafeList(Model model){
        model.addAttribute("myCafeList", cafeAdService.getMyCafeAdList(3L, 0));
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
        return "cafe/cafe_detail";
    }

    @GetMapping("/ticket-purchase")
    public String goToTicket(Model model, Long cafeAdId, Integer type){
        model.addAttribute("tickets", ticketService.getAll());
//        model.addAttribute("cafeId", cafeId);
        return "ticket/ticket";
    }

    @PatchMapping("/ticket-purchase")
    @ResponseBody
    public UpdateStateEnum buyTicket(@RequestBody TicketDTO ticketDTO){
        return cafeAdService.updateDeadLineDate(ticketDTO);
    }

}
