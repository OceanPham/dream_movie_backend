package com.dreammovie.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CinemaService {

    @Autowired
    private CinemaRepository cinemaRepository;

    public List<Cinema> getAllActiveCinemas() {
        // Only return records that are not soft deleted (deletedAt is null)
        return cinemaRepository.findByDeletedAtIsNull();
    }

    public void softDeleteCinema(Long id) {
        Cinema cinema = cinemaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cinema not found"));

        // Set deletedAt to the current time to mark it as deleted
        cinema.setDeletedAt(LocalDateTime.now());
        cinemaRepository.save(cinema);
    }

    // Lấy loại ghế theo ID
    public Optional<Cinema> getCinemaById (Long id){
        return cinemaRepository.findById(id);
    }

    // Thêm mới loại ghế
    public Cinema addCinema(Cinema cinema){
        return cinemaRepository.save(cinema);
    }

    // Cập nhật loại ghế
    public Cinema updateCinema (Long id, Cinema updateCinema){
        Optional<Cinema> categoryOptional = cinemaRepository.findById(id);
        if(categoryOptional.isPresent()){
            Cinema existingCinema = categoryOptional.get();
            existingCinema.setName(updateCinema.getName());
            existingCinema.setAddress(updateCinema.getAddress());
            existingCinema.setPhone(updateCinema.getPhone());

            return cinemaRepository.save(existingCinema);
        }
        return null;
    }


    public void deleteCinema (Long id){
        cinemaRepository.deleteById(id);
    }
}
