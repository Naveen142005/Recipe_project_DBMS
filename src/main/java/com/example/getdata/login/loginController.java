package com.example.getdata.login;

import com.example.getdata.models.login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recipes")
public class loginController {

    loginRepository ls;
    @Autowired
    public void LoginSerive(loginRepository ls){
        this.ls = ls;
    }

    @PostMapping("/savepage")
    public String LoginTODb(login data){
        ls.save(data);
        System.out.println("user:" + data.getEmailId());
        System.out.println("pass" + data.getPassword());
        return "redirect:/";
    }
}
