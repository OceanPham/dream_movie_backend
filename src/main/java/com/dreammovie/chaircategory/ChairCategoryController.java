package com.dreammovie.chaircategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chaircategories")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class ChairCategoryController {

    @Autowired
    private ChairCategoryService chairCategoryService;
    @Autowired
    private ChairCategoryRepository chairCategoryRepository;
    //Get all chair Category
    @GetMapping
    public List<ChairCategory> getAllChairCategory(){
        return chairCategoryService.getAllActiveChairCategories();
    }
//    @GetMapping("/chair-categories")
//    public Page<ChairCategory> getChairCategories(Pageable pageable) {
//        return chairCategoryRepository.findAll(pageable);
//    }
    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<ChairCategory> getChairCategoryById(@PathVariable Long id){
        Optional<ChairCategory> category = chairCategoryService.getChairCategoryById(id);
        return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public ChairCategory addChairCategory(@RequestBody ChairCategory chairCategory){
        return chairCategoryService.addChairCategory(chairCategory);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<ChairCategory> updateChairCategory(@PathVariable Long id, @RequestBody ChairCategory chairCategory){
        ChairCategory updated = chairCategoryService.updateChairCategory(id, chairCategory);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChairCategory(@PathVariable Long id){
        chairCategoryService.softDeleteChairCategory(id);
        return ResponseEntity.ok().build();
    }

}
