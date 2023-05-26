package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import com.example.springboot.service.AnotherMealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AnotherMealController {
    private List<Meal> myMeals = new ArrayList<>();

    AnotherMealService mealService;

    @Autowired
    public AnotherMealController(AnotherMealService mealService){
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getAllMeals(){
        return ResponseEntity.ok(myMeals);
    }

    @PutMapping("/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        try{
            this.myMeals.add(meal);
            return ResponseEntity.ok("Meal Added!");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping("/meal/{name}")
    public ResponseEntity<String> updateMealName(@RequestBody Meal meal, @PathVariable String name){
        myMeals.removeIf(m -> m.getName().equals(name));
        myMeals.add(meal);
        return ResponseEntity.ok("Meal Updated!");
    }

    @DeleteMapping("/meal/{name}")
    public ResponseEntity<String> deleteMealByName(@PathVariable String name){
        myMeals.removeIf(m -> m.getName().equals(name));
        return ResponseEntity.ok("Meal Deleted!");
    }

    @DeleteMapping("/meal/price/{price}")
    public ResponseEntity<String> deleteMealByPrice(@PathVariable double price){
        myMeals.removeIf(m -> m.getPrice() > price);
        return ResponseEntity.ok("Meals with price above " + price + " were deleted!");
    }

    @PutMapping("/meal/{name}/price")
    public ResponseEntity<String> updateMealPriceByName(@PathVariable String name, @RequestParam double price){
        Meal meal = myMeals.stream().filter(m -> m.getName().equals(name)).toList().get(0);
        meal.setPrice(price);
        myMeals.removeIf(m -> m.getName().equals(name));
        myMeals.add(meal);
        return ResponseEntity.ok("Updated Meal!");
    }


}