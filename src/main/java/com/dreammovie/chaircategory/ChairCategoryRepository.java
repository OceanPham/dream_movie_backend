package com.dreammovie.chaircategory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChairCategoryRepository extends JpaRepository <ChairCategory, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<ChairCategory> findByDeletedAtIsNull();
//    Page<ChairCategory> findAll(Pageable pageable);
}
