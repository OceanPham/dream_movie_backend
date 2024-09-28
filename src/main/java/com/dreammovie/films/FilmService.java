package com.dreammovie.films;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmService {
    
    @Autowired   // Tự động inject một instace của FilmRepository vào trong class này, nó tìm thấy implementation đã được tạo tự động và inject vào
    private FilmRepository filmRepository;  // @Autowired sẽ tự động inject bean của FilmRepository vào trong class này, spring data jpa sẽ tự động tạo ra 1 annonymous class chính là 1 proxy implementation của FilmRepository

    public List<Film> getAllActiveFilms() {
        return filmRepository.findByDeletedAtIsNull();
    }

    public void softDeleteFilm(BigInteger id) {
        Film film = filmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Film not found")); // Xử lý ngay khi không tìm thấy

        film.setDeletedAt(LocalDateTime.now());
        filmRepository.save(film);
    }

    public Optional<Film> getFilmById(BigInteger id) {  // Optional là 1 class có sẵn của java, nó là 1 wrapper cho các object, nó giúp tránh được NullPointerException, nó cung cấp các phương thức để xử lý các object có thể null
        return filmRepository.findById(id);
    }     

    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }
    
    public Film updateFilm(BigInteger id, Film updateFilm) {
        return filmRepository.findById(id)
            .map(existingFilm -> {  // .map là 1 phương thức có sẵn của Optional, nó nhận vào 1 function và trả về 1 Optional mới, nếu Optional có value thì nó sẽ áp dụng function này và trả về 1 Optional mới, nếu Optional không có value thì nó sẽ trả về 1 Optional rỗng
                existingFilm.setCategory(updateFilm.getCategory());
                existingFilm.setSupplier(updateFilm.getSupplier());
                existingFilm.setName(updateFilm.getName());
                existingFilm.setThoiluong(updateFilm.getThoiluong());
                existingFilm.setNgaycongchieu(updateFilm.getNgaycongchieu());
                existingFilm.setTrangthai(updateFilm.getTrangthai());
                existingFilm.setMota(updateFilm.getMota());
                existingFilm.setDuongdan(updateFilm.getDuongdan());
                existingFilm.setHinhanh(updateFilm.getHinhanh());
                
                return filmRepository.save(existingFilm);
            })
            .orElseThrow(() -> new RuntimeException("Không tìm thấy phim"));
    }

    public void deleteFilm(BigInteger id) {
        filmRepository.deleteById(id);
    }
}
