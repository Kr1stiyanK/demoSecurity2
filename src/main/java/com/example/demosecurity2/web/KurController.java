package com.example.demosecurity2.web;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KurController {

    @GetMapping("/page/kur")
    public String kur(@AuthenticationPrincipal() String username){
        return "kur";
    }
}
