package com.dreammovie.chaircategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChairCategoryRepository extends JpaRepository <ChairCategory, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
}
