package com.dreammovie.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllActiveUsers() {
        return userRepository.findByDeletedAtIsNull();
    }

    public void softDeleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeletedAt(LocalDateTime.now());
        userRepository.save(user);
    }

    public Optional<User> getUserById (Long id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser (Long id, User updateUser){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            User existingUser = userOptional.get();
            existingUser.setFull_name(updateUser.getFull_name());
            existingUser.setGender(updateUser.getGender());
            existingUser.setRole(updateUser.getRole());
            existingUser.setBirth_day(updateUser.getBirth_day());
            existingUser.setHome_town(updateUser.getHome_town());
            existingUser.setEmail(updateUser.getEmail());
            existingUser.setPhone(updateUser.getPhone());
            existingUser.setPassword(updateUser.getPassword());

            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser (Long id){
        userRepository.deleteById(id);
    }
}
