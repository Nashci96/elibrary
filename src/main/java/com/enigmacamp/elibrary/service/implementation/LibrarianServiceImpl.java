package com.enigmacamp.elibrary.service.implementation;

import com.enigmacamp.elibrary.exception.EntityExistException;
import com.enigmacamp.elibrary.exception.NotFoundException;
import com.enigmacamp.elibrary.model.entity.Librarian;
import com.enigmacamp.elibrary.repository.LibrarianRepo;
import com.enigmacamp.elibrary.service.LibrarianService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibrarianServiceImpl implements LibrarianService {
    @Autowired
    private LibrarianRepo librarianRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<Librarian> listByActive() throws Exception {
        List<Librarian> result = librarianRepo.getListActive();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Librarian> listAll() throws Exception {
        List<Librarian> result = librarianRepo.findAll();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Librarian> listByName(String name) throws Exception {
        List<Librarian> result = librarianRepo.getListByName(name);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Librarian create(Librarian librarian) throws Exception {
        try{
            Librarian librarianNew = librarianRepo.save(librarian);
            return librarianNew;
        } catch (Exception e) {
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Librarian> getById(Integer id) throws Exception {
       Optional<Librarian> result = librarianRepo.findById(id);
       if (result.isEmpty()){
           throw new NotFoundException();
       }
       return result;
    }

    @Override
    public void update(Librarian librarian, Integer id) throws Exception {
        try {
            Optional<Librarian> existingLibrarian = getById(id);
            if (existingLibrarian.isPresent()){
                librarian.setId_librarian(id);
                librarianRepo.save(librarian);
            }
        } catch (Exception e) {
            throw new NotFoundException("Member Not Found");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Optional<Librarian> existingLibrarian = getById(id);
            librarianRepo.delete(existingLibrarian.get());
        } catch (Exception e) {
            throw new NotFoundException("Delete Failed because id not found");
        }
    }
}
