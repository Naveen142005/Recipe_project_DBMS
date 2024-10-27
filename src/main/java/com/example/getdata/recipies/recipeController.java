package com.example.getdata.recipies;

import org.springframework.ui.Model;
import com.example.getdata.models.recipe;

import org.hibernate.internal.ExceptionConverterImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
            @RequestParam("imageFile")  MultipartFile image
    ){
        recipe rs = new recipe();

        rs.setTitle(title);
        rs.setDescription(description);
        rs.setPrepTime(preptime);
        rs.setCookTime(cookTime);
        rs.setTotalTime(totaltime);
        rs.setMainIngredient(main);
        rs.setInstructions(inst);

        System.out.println(title);
        System.out.println(totaltime);
        
        try {
            byte[] img = image.getBytes();
            rs.setImage(img);
            repo.save(rs);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(false, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    

}