package com.example.contoller;
import java.util.ArrayList;
import java.util.List;

import com.example.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
@RequestMapping(value ={"/", "/index"}, method = RequestMethod.GET)
    public String getIndex(){
    return "index";
}
}

