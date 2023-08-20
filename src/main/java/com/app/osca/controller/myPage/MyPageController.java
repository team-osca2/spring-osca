package com.app.osca.controller.myPage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/*")
public class MyPageController {
    @GetMapping("/favourites")
    public void goToFavourites(){;}

    @GetMapping("/point-charge")
    public void goToPointCharge(){;}

    @GetMapping("/payment-api")
    public void goToPaymentAPI(){;}

}

