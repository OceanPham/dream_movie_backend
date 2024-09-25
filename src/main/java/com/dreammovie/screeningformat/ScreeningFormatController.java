package com.dreammovie.screeningformat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screening_formats")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class ScreeningFormatController {

    @Autowired
    private ScreeningFormatService screeningFormatService;
    @Autowired
    private ScreeningFormatRepository screeningFormatRepository;
    //Get all chair Category
    @GetMapping
    public List<ScreeningFormat> getAllScreeningFormat(){
        return screeningFormatService.getAllActiveScreeningFormats();
    }

    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<ScreeningFormat> getScreeningFormatId(@PathVariable Long id){
        Optional<ScreeningFormat> screeningFormat = screeningFormatService.getScreeningFormatById(id);
        return screeningFormat.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public ScreeningFormat addScreeningFormat(@RequestBody ScreeningFormat screeningFormat){
        return screeningFormatService.addScreeningFormat(screeningFormat);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<ScreeningFormat> updateScreeningFormat(@PathVariable Long id, @RequestBody ScreeningFormat screeningFormat){
        ScreeningFormat updated = screeningFormatService.updateScreeningFormat(id, screeningFormat);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreeningFormat(@PathVariable Long id){
        screeningFormatService.deleteScreeningFormat(id);
        return ResponseEntity.ok().build();
    }

}
