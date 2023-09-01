package com.app.osca.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class MemberIdNotFoundException extends RuntimeException{

    @ExceptionHandler(MemberIdNotFoundException.class)
    public String notFound(){
        return "/error/not-found";
    }

}
