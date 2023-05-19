package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class MyController {
    List<Meal> myMeals = Arrays.asList(
            new Meal("Carbonara", "Pasta Carbonara", 12.9d, true),
            new Meal("Pesto", "Pasta Pesto", 9.9d, true),
            new Meal("Minestrone", "Vegetable Soup", 6.9d, false)
    );

    @GetMapping("/meal/price")
    public ResponseEntity<List<Meal>> getMealsByPrice(@RequestParam ("min") double min, @RequestParam("max") double max){
        return ResponseEntity.ok(myMeals.stream().filter(m -> m.getPrice() < max && m.getPrice() > min).toList());
    }


    /*
    Exercise 4: Create a GetMapping that returns a meal by price range

1 - Annotate a new class with the @RestController annotation.
2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
 3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
 4 - Return a list of Meal objects with prices within the specified range.

     */
}
