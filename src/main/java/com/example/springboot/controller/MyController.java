package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyController {
    List<Meal> myMeals = Arrays.asList(
            new Meal("Carbonara", "Pasta Carbonara", 12.9d, true),
            new Meal("Pesto", "Pasta Pesto", 12.9d, true),
            new Meal("Minestrone", "Vegetable Soup", 12.9d, false)
    );

    @GetMapping(value = ("/meal/description-match/{phrase}"))
    public ResponseEntity<Meal> getMealByDescription(@PathVariable("phrase") String description){
       return ResponseEntity.ok(myMeals.stream().filter(m -> m.getDescription().equals(description)).toList().get(0));
    }
}

/*
Exercise 3: Create a GetMapping that returns a meal by any word of description

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meal/description-match/{phrase}" using the @GetMapping annotation.
3 - In the method, add a query parameter "description" using the @PathVariable annotation.
4 - Return a Meal object with the corresponding description.

 */
