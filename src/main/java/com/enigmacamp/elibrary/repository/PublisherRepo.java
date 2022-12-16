package com.enigmacamp.elibrary.repository;

import com.enigmacamp.elibrary.model.entity.Book;
import com.enigmacamp.elibrary.model.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PublisherRepo extends JpaRepository<Publisher,Integer> {
    @Query(value = "SELECT * FROM t_publisher WHERE publisher_name like %?1% AND is_active = 1",nativeQuery = true)
    List<Publisher> getListByName(String name);

    @Query(value = "SELECT * FROM t_publisher WHERE publisher_name = ?1 AND is_active = 1 ",nativeQuery = true)
    Publisher getByName(String name);
}
