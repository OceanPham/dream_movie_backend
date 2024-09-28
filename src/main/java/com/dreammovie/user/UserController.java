package com.dreammovie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    //Get all chair Category
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllActiveUsers();
    }

    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserId(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
        User updated = userService.updateUser(id, user);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

}
