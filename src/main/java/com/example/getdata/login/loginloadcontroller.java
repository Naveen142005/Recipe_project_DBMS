package com.example.getdata.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("recipes/")
public class loginloadcontroller {
    @GetMapping("login")
    public String loginpage(){
        return "login";
    }
}
