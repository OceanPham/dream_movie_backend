package com.dreammovie.food_categories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food_categories")
@CrossOrigin(origins = "http://localhost:3000")

public class FoodCategories_Controller {
    
    @Autowired
    private FoodCategories_Service foodCategories_Service;

    @GetMapping
    public List<FoodCategories> getAllActiveFoodCategories() {
        return foodCategories_Service.getAllActiveFoodCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FoodCategories> getFoodCategoryById(@PathVariable Long id) {
        Optional<FoodCategories> foodCategory = foodCategories_Service.getFoodCategoryById(id);
        return foodCategory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Nếu foodCategory có giá trị thì trả về 1 ResponseEntity với status code 200, nếu không có giá trị thì trả về 1 ResponseEntity với status code 404
    }

    @PostMapping
    public FoodCategories addFoodCategory(@RequestBody FoodCategories foodCategories) {
        return foodCategories_Service.addFoodCategory(foodCategories);
    }

    @PostMapping("/{id}")
    public ResponseEntity<FoodCategories> updateFoodCategory(@PathVariable Long id, @RequestBody FoodCategories foodCategories) {
        FoodCategories updated = foodCategories_Service.updateFoodCategory(id, foodCategories);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodCategory(@PathVariable Long id) {
        foodCategories_Service.deleteFoodCategory(id);
        return ResponseEntity.ok().build();
    }
}
