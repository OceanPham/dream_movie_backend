package com.dreammovie.nhanvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    // Lấy tất cả các loại ghế
//    public List<NhanVien> getAllChairCategories(){
//        return NhanVienRepository.findAll();
//    }

    public List<NhanVien> getAllActiveNhanviens() {
        // Only return records that are not soft deleted (deletedAt is null)
        return nhanVienRepository.findByDeletedAtIsNull();
    }

    public void softDeleteNhanVien(Long id) {
        NhanVien nhanVien = nhanVienRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("NhanVien not found"));

        // Set deletedAt to the current time to mark it as deleted
        nhanVien.setDeletedAt(LocalDateTime.now());
        nhanVienRepository.save(nhanVien);
    }

    // Lấy loại ghế theo ID
    public Optional<NhanVien> getNhanVienById (Long id){
        return nhanVienRepository.findById(id);
    }

    // Thêm mới loại ghế
    public NhanVien addNhanVien(NhanVien nhanVien){
        return nhanVienRepository.save(nhanVien);
    }

    // Cập nhật loại ghế
    public NhanVien updateNhanVien (Long id, NhanVien updateNhanVien){
        Optional<NhanVien> nhanVienOptional = nhanVienRepository.findById(id);
        if(nhanVienOptional.isPresent()){
            NhanVien existingNhanVien = nhanVienOptional.get();
            existingNhanVien.setTen_dang_nhap_nv(updateNhanVien.getTen_dang_nhap_nv());
            return nhanVienRepository.save(existingNhanVien);
        }
        return null;
    }


    public void deleteNhanVien (Long id){
        nhanVienRepository.deleteById(id);
    }
}
