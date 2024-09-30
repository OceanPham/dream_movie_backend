package com.dreammovie.food_categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  FoodCategories_Repository extends JpaRepository<FoodCategories, Long> {
    List<FoodCategories> findByDeletedAtIsNull();
    
}
