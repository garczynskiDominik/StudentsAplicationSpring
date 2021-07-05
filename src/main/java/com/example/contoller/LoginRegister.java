package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginRegister {
    @RequestMapping(value ={"/login"}, method = RequestMethod.GET)
    public String getLogin(){
        return "loginpages/login";
    }

    @RequestMapping(value ={"/login"}, method = RequestMethod.POST)
    public String postLogin(){
        return "loginpages/login";
    }

    @RequestMapping(value ={"/register"}, method = RequestMethod.GET)
    public String getRegister(){
        return "loginpages/register";
    }
}
