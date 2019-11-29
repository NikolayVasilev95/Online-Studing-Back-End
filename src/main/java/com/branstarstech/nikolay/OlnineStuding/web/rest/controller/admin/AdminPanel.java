package com.branstarstech.nikolay.OlnineStuding.web.rest.controller.admin;

import com.branstarstech.nikolay.OlnineStuding.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminPanel {
    @Autowired
    UserService userService;

    @GetMapping(value = "/api/admin/")
    public String adminPanelViewAllUsers(){
        return "test";
    }
}
