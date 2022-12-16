package com.enigmacamp.elibrary.service;

import com.enigmacamp.elibrary.model.entity.Librarian;

import java.util.List;
import java.util.Optional;

public interface LibrarianService {
    List<Librarian> listByActive() throws Exception;
    List<Librarian> listAll() throws Exception;
    List<Librarian> listByName(String name) throws Exception;
    Librarian create(Librarian librarian) throws Exception;
    Optional<Librarian> getById(Integer id) throws Exception;
    void update(Librarian librarian,Integer id) throws Exception;
    void delete(Integer id) throws Exception;

}
