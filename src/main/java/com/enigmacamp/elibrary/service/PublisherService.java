package com.enigmacamp.elibrary.service;

import com.enigmacamp.elibrary.model.entity.Publisher;

import java.util.List;
import java.util.Optional;

public interface PublisherService {
    List<Publisher> list() throws Exception;
    List<Publisher> listByName(String name) throws Exception;
    Publisher create(Publisher publisher) throws Exception;
    Optional<Publisher> getById(Integer id) throws Exception;
    Publisher getByName(String name) throws Exception;
    void update(Publisher publisher,Integer id) throws Exception;
    void delete(Integer id) throws Exception;

}
