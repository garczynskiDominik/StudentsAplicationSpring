package com.example.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


@GetMapping(value ={"/", "/index"})
    public String getIndex(){
    return "index";
}
}

