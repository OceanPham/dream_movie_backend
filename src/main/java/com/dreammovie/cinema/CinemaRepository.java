package com.dreammovie.cinema;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository <Cinema, Long> {
// JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<Cinema> findByDeletedAtIsNull();
}
