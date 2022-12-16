package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRepo extends JpaRepository<Borrow,Integer> {
}
