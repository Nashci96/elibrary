package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Librarian;
import com.enigmacamp.elibrary.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibrarianRepo extends JpaRepository<Librarian,Integer> {
    @Query(value = "SELECT * FROM t_librarian WHERE is_active = 1",nativeQuery = true)
    List<Librarian> getListActive();

    @Query(value = "SELECT * FROM t_librarian WHERE name like %?1% AND is_active = 1  ",nativeQuery = true)
    List<Librarian> getListByName(String name);


}
