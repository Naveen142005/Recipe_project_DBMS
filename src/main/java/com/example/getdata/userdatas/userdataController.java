package com.example.getdata.userdatas;

import com.example.getdata.models.recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/recipes")
public class userdataController {
    @Autowired
    userdataRepository us;

    userdataController(userdataRepository us){
        this.us = us;
    }
    @PostMapping("/add")
    @ResponseBody

    public  void info(@RequestBody recipe data, @RequestParam MultipartFile file) throws IOException {
        if (!file.isEmpty()) {
            data.setImage(file.getBytes());
        }
        us.save(data);
    }
}
