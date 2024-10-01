package com.dreammovie.food_categories;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoodCategories_Service {
    
    @Autowired
    private FoodCategories_Repository foodCategories_Repository;

    public List<FoodCategories> getAllActiveFoodCategories() {
        return foodCategories_Repository.findByDeletedAtIsNull();
    }

    public void softDeleteFoodCategory(Long id) {
        FoodCategories foodCategories = foodCategories_Repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Food category not found"));

        foodCategories.setDeletedAt(LocalDateTime.now());
        foodCategories_Repository.save(foodCategories);
    }

    public FoodCategories addFoodCategory(FoodCategories foodCategories) {
        return foodCategories_Repository.save(foodCategories);
    }

    public FoodCategories updateFoodCategory(Long id, FoodCategories updateFoodCategory) {
        return foodCategories_Repository.findById(id)
            .map(existingFoodCategory -> {
                existingFoodCategory.setName(updateFoodCategory.getName());
                existingFoodCategory.setDescription(updateFoodCategory.getDescription());
                existingFoodCategory.setMax_stock_quatity(updateFoodCategory.getMax_stock_quatity());
                
                return foodCategories_Repository.save(existingFoodCategory);
            })
            .orElseThrow(() -> new RuntimeException("Không tìm thấy danh mục thức ăn"));
    }

    public void deleteFoodCategory(Long id) {
        foodCategories_Repository.deleteById(id);
    }

    public Optional<FoodCategories> getFoodCategoryById(Long id) {
        return foodCategories_Repository.findById(id);
    }
}
