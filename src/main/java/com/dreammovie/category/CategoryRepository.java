package com.dreammovie.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<Category> findByDeletedAtIsNull();
//    Page<ChairCategory> findAll(Pageable pageable);
}
