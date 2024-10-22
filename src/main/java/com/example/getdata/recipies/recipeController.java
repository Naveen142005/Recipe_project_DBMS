package com.example.getdata.recipies;

import org.springframework.ui.Model;
import com.example.getdata.models.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class recipeController {

    @Autowired
    recipeRepository rs;

    @GetMapping("")
    public String getRecipePage() {
        return "index";
    }


    @PostMapping("/add")
    @ResponseBody
    public Boolean postMethodName(@RequestPart recipe  recipe_data , MultipartFile image) {
        try {
            recipe_data.setImage(image);
            rs.save(recipe_data);
            return true;
        }
        catch(Exception e) {
            return false;
        }
    }

}