package com.dreammovie.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/languages")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class LanguageController {

    @Autowired
    private LanguageService languageService;
    @Autowired
    private LanguageRepository languageRepository;
    //Get all chair Category
    @GetMapping
    public List<Language> getAllLanguage(){
        return languageService.getAllActiveLanguages();
    }

    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<Language> getLanguageId(@PathVariable Long id){
        Optional<Language> language = languageService.getLanguageById(id);
        return language.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public Language addLanguage(@RequestBody Language language){
        return languageService.addLanguage(language);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Language> updateLanguage(@PathVariable Long id, @RequestBody Language language){
        Language updated = languageService.updateLanguage(id, language);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguage(@PathVariable Long id){
        languageService.deleteLanguage(id);
        return ResponseEntity.ok().build();
    }

}
