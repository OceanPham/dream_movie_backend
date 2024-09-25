package com.dreammovie.films;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController     // Đánh dấu lớp này là một RESTful web service, kết hợp @ResponseBody và @Controller, để xử lý các yêu cầu HTTP và trả về dữ liệu trực tiếp(JSON), giúp tạo ra các RESTful API
@RequestMapping("/api/films")    // Định nghĩa đường dẫn cơ sở cho tất cả các endpoint trong controller này
@CrossOrigin(origins = "http://localhost:3000")    // Cho phép các request từ frontend có cổng 3000 truy cập vào các endpoint trong controller này

public class FilmController {
    
    @Autowired
    private FilmService filmService;
    
    // Anh xa cac request HTTP GET den phuong thuc nay
    @GetMapping
    public List<Film> getAllFilm() {
        return filmService.getAllActiveFilms();
    }

    // Find film by id
    @GetMapping("/{id}")
    public ResponseEntity<Film> getFilmById(@PathVariable BigInteger id) {  // @PathVariable giúp lấy giá trị từ đường dẫn URL và gán vào biến id
        Optional<Film> film = filmService.getFilmById(id);
        return film.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); // Nếu film có giá trị thì trả về 1 ResponseEntity với status code 200, nếu không có giá trị thì trả về 1 ResponseEntity với status code 404
    }

    // Add new film
    @PostMapping
    public Film addFilm(@RequestBody Film film) {
        return filmService.addFilm(film);
    }

    // Update film
    @PostMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@PathVariable BigInteger id, @RequestBody Film currentFilm) {
        Film updated = filmService.updateFilm(id, currentFilm);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }
    
    // Delete film
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFillm(@PathVariable BigInteger id) {
        filmService.deleteFilm(id);
        return ResponseEntity.ok().build();
    }
}
