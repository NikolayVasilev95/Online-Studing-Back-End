package com.branstarstech.nikolay.OlnineStuding.web.rest.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Home {
    @GetMapping(value = "/api/user-home/")
    public String home(){
        return "User home";
    }
}
