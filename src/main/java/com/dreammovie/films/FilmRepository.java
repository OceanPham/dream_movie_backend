package com.dreammovie.films;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, BigInteger> {   // JpaRepository cũng là 1 interface có sẵn của Spring Data JPA, nên FilmRepository chỉ kế thừa interface từ jpaRepository, cung cấp sẵn các phương thức CRUD
    List<Film> findByDeletedAtIsNull();
}
