package com.dreammovie.supplier;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository <Supplier, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<Supplier> findByDeletedAtIsNull();
//    Page<ChairCategory> findAll(Pageable pageable);
}
