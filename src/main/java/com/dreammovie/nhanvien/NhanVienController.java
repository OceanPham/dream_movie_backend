package com.dreammovie.nhanvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nhan_viens")
@CrossOrigin(origins = "http://localhost:3000") // Cho phép các request từ frontend
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    //Get all chair Category
    @GetMapping
    public List<NhanVien> getAllNhanVien(){
        return nhanVienService.getAllActiveNhanviens();
    }

    //Get chair category by id
    @GetMapping("/{id}")
    public ResponseEntity<NhanVien> getNhanVienById(@PathVariable Long id){
        Optional<NhanVien> category = nhanVienService.getNhanVienById(id);
        return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Add new
    @PostMapping
    public NhanVien addNhanVien(@RequestBody NhanVien nhanVien){
        return nhanVienService.addNhanVien(nhanVien);
    }

    //Update
    @PutMapping("/{id}")
    public  ResponseEntity<NhanVien> updateNhanVien(@PathVariable Long id, @RequestBody NhanVien nhanVien){
        NhanVien updated = nhanVienService.updateNhanVien(id, nhanVien);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }
        return ResponseEntity.notFound().build();
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNhanVien(@PathVariable Long id){
        nhanVienService.deleteNhanVien(id);
        return ResponseEntity.ok().build();
    }

}
