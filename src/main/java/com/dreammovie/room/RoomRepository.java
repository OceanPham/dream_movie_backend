package com.dreammovie.room;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository <Room, Long> {
    // JpaRepository đã cung cấp sẵn các thao tác CRUD.
    List<Room> findByDeletedAtIsNull();
}
