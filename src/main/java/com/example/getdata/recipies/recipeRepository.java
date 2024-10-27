package com.example.getdata.recipies;

import com.example.getdata.models.recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface recipeRepository extends JpaRepository<recipe,Integer> {
    @Query("SELECT r FROM recipe r WHERE LOWER(r.title) = LOWER(:title)")
    List<recipe> findByTitle(@Param("title") String title);
    

}
