package com.example.getdata.recipies;

import org.springframework.ui.Model;
import com.example.getdata.models.recipe;

import org.hibernate.internal.ExceptionConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class recipeController {

    @Autowired
    recipeRepository repo;

    @GetMapping("/")
    public String getRecipePage() {
        return "index";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<Boolean> postMethodName(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("prepTime") int preptime,
            @RequestParam("cookTime") int cookTime,
            @RequestParam("totalTime") int totaltime,
            @RequestParam("mainIngredient") String main,
            @RequestParam("instructions")  String inst,
            @RequestParam(value = "imageFile" , required = false)  MultipartFile image
    ){
        recipe rs = new recipe();
        rs.setTitle(title);
        rs.setDescription(description);
        rs.setPrepTime(preptime);
        rs.setCookTime(cookTime);
        rs.setTotalTime(totaltime);
        rs.setMainIngredient(main);
        rs.setInstructions(inst);

        
        try {
            rs.setImage((image.getBytes()));
            repo.save(rs);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @GetMapping("/search/{recipe_name}")
    
    public String RecipeLoader(@PathVariable("recipe_name") String name){
        System.out.println(name);
        List<recipe> recipe = repo.findByTitle(name);
        ModelAndView mv = new ModelAndView("recipePage");
        mv.addObject("recipePage", recipe);
        return "recipePage";
    }
    

}