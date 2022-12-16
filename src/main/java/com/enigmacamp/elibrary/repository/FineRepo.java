package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Fine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FineRepo extends JpaRepository<Fine,Integer> {
}
