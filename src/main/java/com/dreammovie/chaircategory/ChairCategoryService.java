package com.dreammovie.chaircategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChairCategoryService {

    @Autowired
    private ChairCategoryRepository chairCategoryRepository;

    // Lấy tất cả các loại ghế
//    public List<ChairCategory> getAllChairCategories(){
//        return chairCategoryRepository.findAll();
//    }

    public List<ChairCategory> getAllActiveChairCategories() {
        // Only return records that are not soft deleted (deletedAt is null)
        return chairCategoryRepository.findByDeletedAtIsNull();
    }

    public void softDeleteChairCategory(Long id) {
        ChairCategory chairCategory = chairCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChairCategory not found"));

        // Set deletedAt to the current time to mark it as deleted
        chairCategory.setDeletedAt(LocalDateTime.now());
        chairCategoryRepository.save(chairCategory);
    }

    // Lấy loại ghế theo ID
    public Optional<ChairCategory> getChairCategoryById (Long id){
        return chairCategoryRepository.findById(id);
    }

    // Thêm mới loại ghế
    public ChairCategory addChairCategory(ChairCategory chairCategory){
        return chairCategoryRepository.save(chairCategory);
    }

    // Cập nhật loại ghế
    public ChairCategory updateChairCategory (Long id, ChairCategory updateChairCategory){
        Optional<ChairCategory> categoryOptional = chairCategoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            ChairCategory existingCategory = categoryOptional.get();
            existingCategory.setName(updateChairCategory.getName());
            existingCategory.setDescription(updateChairCategory.getDescription());
            existingCategory.setPrice(updateChairCategory.getPrice());
            existingCategory.setSeatCount(updateChairCategory.getSeatCount());

            return chairCategoryRepository.save(existingCategory);
        }
        return null;
    }


    public void deleteChairCategory (Long id){
        chairCategoryRepository.deleteById(id);
    }
}
