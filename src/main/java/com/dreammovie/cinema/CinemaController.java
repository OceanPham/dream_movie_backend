package com.dreammovie.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cinemas")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class CinemaController {

    @Autowired
    private CinemaService cinemaService;
    @Autowired
    private CinemaRepository cinemaRepository;
    //Get all chair Category
    @GetMapping
    public List<Cinema> getAllCinema(){
        return cinemaService.getAllActiveCinemas();
    }
//    @GetMapping("/chair-categories")
//    public Page<ChairCategory> getChairCategories(Pageable pageable) {
//        return chairCategoryRepository.findAll(pageable);
//    }
    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<Cinema> getCinemaId(@PathVariable Long id){
        Optional<Cinema> cinema = cinemaService.getCinemaById(id);
        return cinema.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public Cinema addCinema(@RequestBody Cinema cinema){
        return cinemaService.addCinema(cinema);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Cinema> updateCinema(@PathVariable Long id, @RequestBody Cinema cinema){
        Cinema updated = cinemaService.updateCinema(id, cinema);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCinema(@PathVariable Long id){
        cinemaService.deleteCinema(id);
        return ResponseEntity.ok().build();
    }

}
