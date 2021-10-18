package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegister {


    @GetMapping(value = {"/login"})
    public String getLogin() {
        return "loginpages/login";
    }

    @PostMapping(value = {"/login"})
    public String postLogin() {
        return "loginpages/login";
    }

    @GetMapping(value = {"/register"})
    public String getRegister() {
        return "loginpages/register";
    }


}
