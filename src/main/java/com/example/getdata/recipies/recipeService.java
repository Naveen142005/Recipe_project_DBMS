package com.example.getdata.recipies;

import com.example.getdata.models.recipe;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class recipeService {
    recipeRepository repository;
    public recipeService(recipeRepository rs){
        this.repository = rs;
    }

    public recipe findRecipe(String title){
        return  repository.findByTitle(title).get(0);
//        if(optional.isPresent())
//            return optional.get();
//        return null;
    }
}