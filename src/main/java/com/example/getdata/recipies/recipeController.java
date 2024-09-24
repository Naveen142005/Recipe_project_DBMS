package com.example.getdata.recipies;

import org.springframework.ui.Model;
import com.example.getdata.models.recipe;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("recipes/")
public class recipeController {
    recipeService recipeservice;

    public recipeController(recipeService recipeservice){
        this.recipeservice = recipeservice;
    }

    @GetMapping("")
    public String getRecipePage(){
        return "index";
    }

    @GetMapping("{Recipename}")
    public String getRecipe(Model model, @PathVariable String Recipename){
        recipe recipe= recipeservice.findRecipe(Recipename);
        System.out.println(recipe);
        String img = java.util.Base64.getEncoder().encodeToString(recipe.getImage());
        model.addAttribute("recipe",recipe);
        model.addAttribute("image64",img);
        System.out.println(recipe);
        return "recipe";
    }

}