package com.dreammovie.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class RoomController {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;
    //Get all chair Category
    @GetMapping
    public List<Room> getAllRoom(){
        return roomService.getAllActiveRooms();
    }
//    @GetMapping("/chair-categories")
//    public Page<ChairCategory> getChairCategories(Pageable pageable) {
//        return chairCategoryRepository.findAll(pageable);
//    }
    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomId(@PathVariable Long id){
        Optional<Room> room = roomService.getRoomById(id);
        return room.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public Room addRoom(@RequestBody Room room){
        return roomService.addRoom(room);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room){
        Room updated = roomService.updateRoom(id, room);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id){
        roomService.deleteRoom(id);
        return ResponseEntity.ok().build();
    }

}
