package com.dreammovie.showtime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/show_times")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class ShowTimeController {

    @Autowired
    private ShowTimeService showTimeService;

    @Autowired
    private ShowTimeRepository showTimeRepository;

    @GetMapping
    public List<ShowTime> getAllShowTimes(){
        return showTimeService.getAllActiveShowTimes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowTime> getShowTimeId(@PathVariable Long id){
        Optional<ShowTime> showTime = showTimeService.getShowTimeById(id);
        return showTime.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShowTime addShowTime (@RequestBody ShowTime showTime){
        return showTimeService.addShowTime(showTime);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShowTime> updateShowTime (@PathVariable Long id, @RequestBody ShowTime showTime){
        ShowTime updateShowTime = showTimeService.updateShowTime(id, showTime);
        if(updateShowTime != null){
            return ResponseEntity.ok(updateShowTime);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowTime (@PathVariable Long id){
        showTimeService.softDeleteShowTime(id);
        return ResponseEntity.ok().build();
    }
}
