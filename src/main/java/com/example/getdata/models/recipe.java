package com.example.getdata.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Recipe")
@Getter
@Setter
public class recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "prep_time")
    private Integer prepTime;

    @Column(name = "cook_time")
    private Integer cookTime;

    @Column(name = "total_time")
    private Integer totalTime;

    @Column(name = "main_ingredient", length = 100)
    private String mainIngredient;

    @Column(name = "instructions", columnDefinition = "TEXT")
    private String instructions;

    private byte[] image;

    public recipe() {
        // Default constructor
    }

    public recipe(String title, String description, Integer prepTime, Integer cookTime, Integer totalTime, String mainIngredient, String instructions,byte[] image) {
        this.title = title;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.totalTime = totalTime;
        this.mainIngredient = mainIngredient;
        this.instructions = instructions;
        this.image = image;

    }
    // Constructors, getters, and setters
    // You can generate them using your IDE or write them manually
}
