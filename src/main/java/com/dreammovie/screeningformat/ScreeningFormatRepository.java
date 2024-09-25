package com.dreammovie.screeningformat;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningFormatRepository extends JpaRepository <ScreeningFormat, Long> {
    // JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<ScreeningFormat> findByDeletedAtIsNull();
}
