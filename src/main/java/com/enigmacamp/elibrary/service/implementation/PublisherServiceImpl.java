package com.enigmacamp.elibrary.service.implementation;

import com.enigmacamp.elibrary.exception.EntityExistException;
import com.enigmacamp.elibrary.exception.NotFoundException;
import com.enigmacamp.elibrary.model.entity.Publisher;
import com.enigmacamp.elibrary.repository.PublisherRepo;
import com.enigmacamp.elibrary.service.PublisherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherServiceImpl implements PublisherService {
    @Autowired
    private PublisherRepo publisherRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Publisher> list() throws Exception {
        List<Publisher> result = publisherRepo.findAll();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Publisher> listByName(String name) throws Exception {
        List<Publisher> result = publisherRepo.getListByName(name);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Publisher create(Publisher publisher) throws Exception {
        try {
            Publisher newPublisher = publisherRepo.save(publisher);
            return newPublisher;
        } catch (Exception e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Publisher> getById(Integer id) throws Exception {
        Optional<Publisher> result = publisherRepo.findById(id);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Publisher getByName(String name) throws Exception {
        try {
            Publisher result = publisherRepo.getByName(name);
            return result;
        } catch (Exception e) {
            throw new NotFoundException("Publisher Not Found");
        }
    }

    @Override
    public void update(Publisher publisher, Integer id) throws Exception {
        try {
            Optional<Publisher> existingPublisher = getById(id);
            if (existingPublisher.isPresent()) {
                publisher.setId_publisher(id);
                publisherRepo.save(publisher);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new NotFoundException("Publisher Not Found");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Optional<Publisher> existingPublisher = getById(id);
            publisherRepo.delete(existingPublisher.get());
        } catch (Exception e){
            throw new NotFoundException("Delete failed because id not found");
        }
    }
}
