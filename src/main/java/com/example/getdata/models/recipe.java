package com.example.getdata.models;

import org.springframework.web.multipart.MultipartFile;

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

    @Lob
    private byte[] image;

    public recipe() {
        // Default constructor
    }

    public void setImage(MultipartFile image2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setImage'");
    }
    // Constructors, getters, and setters
    // You can generate them using your IDE or write them manually
}

