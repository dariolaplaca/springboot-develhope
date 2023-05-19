package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@RestController
public class MyController {

    List<Meal> myMeals = Arrays.asList(
            new Meal("Pasta Pesto", "Pasta with pesto", 9d, true),
            new Meal("Minestrone", "Soup with lot of vegetables", 6d, false),
            new Meal("BLT", "Sandwich with Bacon, Lettuce and Tomatoes", 3.5d, true),
            new Meal("Carbonara", "Pasta with eggs, parmesan, pecorino, guanciale and pepper", 12.9d, true),
            new Meal("Chicken Nuggets", "Chicken Nuggets", 4d, true)
    );

    @GetMapping(value = "/meal")
    public ResponseEntity<List<Meal>> getMeals(){
        return ResponseEntity.ok(myMeals);
    }
}
