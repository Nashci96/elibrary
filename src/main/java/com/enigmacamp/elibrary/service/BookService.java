package com.enigmacamp.elibrary.service;

import com.enigmacamp.elibrary.model.entity.Book;
import com.enigmacamp.elibrary.model.entity.Member;
import com.enigmacamp.elibrary.model.request.BookRequest;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> listByActive() throws Exception;
    List<Book> listAll() throws Exception;
    List<Book> listByName(String name) throws Exception;
    Book create(BookRequest book) throws Exception;
    Optional<Book> getById(Integer id) throws Exception;
    void update(Book book,Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
