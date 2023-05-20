package com.example.springboot.controller;

import com.example.springboot.model.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    private List<Meal> myMeals = new ArrayList<>();

    @GetMapping("/meals")
    public ResponseEntity<List<Meal>> getAllMeals(){
        return ResponseEntity.ok(myMeals);
    }

    @PutMapping("/meal")
    public ResponseEntity<String> putMeal(@RequestBody Meal meal){
        this.myMeals.add(meal);
        return ResponseEntity.ok("Meal Added!");
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




/*
Exercise 1: Create a PutMapping to add a new meal

1 - Create a new endpoint "/meal" using the @PostMapping annotation.
3 - In the method, add a RequestBody for the new Meal object.
4 - Add the new meal to the list of meals.

Exercise 2: Create a PostMapping to update a meal by name

1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
3 - Update the meal with the corresponding name using the information from the RequestBody.

Exercise 3: Create a DeleteMapping to delete a meal by name

1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
2 - In the method, add a PathVariable for the name.
3 - Delete the meal with the corresponding name.

Exercise 4: Create a DeleteMapping to delete all meals above a certain price

1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
2 - In the method, add a PathVariable for the price.
3 - Delete all meals with a price above the price from the PathVariable.

Exercise 5: Create a PutMapping to update the price of a meal by name

1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
 */
