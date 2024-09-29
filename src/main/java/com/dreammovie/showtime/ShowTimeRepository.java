package com.dreammovie.showtime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowTimeRepository extends JpaRepository <ShowTime,Long> {
    List<ShowTime> findByDeletedAtIsNull();
}
