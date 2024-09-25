package com.dreammovie.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllActiveCategories() {
        return categoryRepository.findByDeletedAtIsNull();
    }

    public void softDeleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        // Set deletedAt to the current time to mark it as deleted
        category.setDeletedAt(LocalDateTime.now());
        categoryRepository.save(category);
    }

    // Lấy loại ghế theo ID
    public Optional<Category> getCategoryById (Long id){
        return categoryRepository.findById(id);
    }

    // Thêm mới loại ghế
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    // Cập nhật loại ghế
    public Category updateCategory (Long id, Category updateCategory){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            Category existingCategory = categoryOptional.get();
            existingCategory.setName(updateCategory.getName());
            existingCategory.setDescription(updateCategory.getDescription());

            return categoryRepository.save(existingCategory);
        }
        return null;
    }


    public void deleteCategory (Long id){
        categoryRepository.deleteById(id);
    }
}
