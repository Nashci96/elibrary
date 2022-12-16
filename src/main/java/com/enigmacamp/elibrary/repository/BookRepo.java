package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Book;
import com.enigmacamp.elibrary.model.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,Integer> {
    @Query(value = "SELECT * FROM t_book WHERE is_active = 1",nativeQuery = true)
    List<Book> getListActive();

    @Query(value = "SELECT * FROM t_book WHERE title like %?1% AND  is_active = 1 ",nativeQuery = true)
    List<Book> getListByName(String name);

}
