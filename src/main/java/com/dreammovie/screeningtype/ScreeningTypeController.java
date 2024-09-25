package com.dreammovie.screeningtype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screeningtypes")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class ScreeningTypeController {

    @Autowired
    private ScreeningTypeService screeningTypeService;
    @Autowired
    private ScreeningTypeRepository screeningTypeRepository;
    //Get all chair Category
    @GetMapping
    public List<ScreeningType> getAllScreeningType(){
        return screeningTypeService.getAllActiveScreeningTypes();
    }

    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<ScreeningType> getScreeningTypeId(@PathVariable Long id){
        Optional<ScreeningType> screeningType = screeningTypeService.getScreeningTypeById(id);
        return screeningType.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public ScreeningType addScreeningType(@RequestBody ScreeningType screeningType){
        return screeningTypeService.addScreeningType(screeningType);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<ScreeningType> updateScreeningType(@PathVariable Long id, @RequestBody ScreeningType screeningType){
        ScreeningType updated = screeningTypeService.updateScreeningType(id, screeningType);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreeningType(@PathVariable Long id){
        screeningTypeService.deleteScreeningType(id);
        return ResponseEntity.ok().build();
    }

}
