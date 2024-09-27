package com.dreammovie.nhanvien;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository <NhanVien, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<NhanVien> findByDeletedAtIsNull();
//    Page<ChairCategory> findAll(Pageable pageable);
}
