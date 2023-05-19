package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MyController {

    List<Meal> myMeals = Arrays.asList(
            new Meal("Carbonara", "Carbonara Pasta", 12.9d, true),
            new Meal("Pasta Pesto", "Pesto Pasta", 9d, true),
            new Meal("Minestrone", "Vegetable Soup", 6d, false)
    );

    @GetMapping(value = "meal/{name}")
    public ResponseEntity<Meal> getMealByName(@PathVariable("name") String name){
        return ResponseEntity.ok(myMeals.stream().filter(m -> m.getName().equals(name)).toList().get(0));
    }
}
