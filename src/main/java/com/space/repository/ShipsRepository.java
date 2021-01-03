package com.space.repository;

import com.space.model.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipsRepository extends JpaRepository<Ship, Long> {

    //Ship findById(Long id);
}
