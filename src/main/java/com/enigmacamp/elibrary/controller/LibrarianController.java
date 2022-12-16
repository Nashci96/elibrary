package com.enigmacamp.elibrary.controller;

import com.enigmacamp.elibrary.model.entity.Librarian;
import com.enigmacamp.elibrary.model.request.LibrarianRequest;
import com.enigmacamp.elibrary.model.response.SuccessResponse;
import com.enigmacamp.elibrary.service.LibrarianService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/librarians")
public class LibrarianController {
    @Autowired
    private LibrarianService librarianService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity getAllActiceMember() throws Exception{
        List<Librarian> librarians = librarianService.listByActive();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get all librarian data",librarians));
    }

    @PostMapping ResponseEntity createLibrarian(@RequestBody LibrarianRequest librarianRequest) throws Exception{
        Librarian newLibrarian = modelMapper.map(librarianRequest,Librarian.class);
        Librarian result = librarianService.create(newLibrarian);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("Success Created Member",result));
    }

    @GetMapping("/all")
    public ResponseEntity getAllLibrarian() throws Exception{
        List<Librarian> librarians = librarianService.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Get All Librarian Data",librarians));
    }

    @GetMapping("/list-by-name/{name}")
    public ResponseEntity getAllLibrarianByName(@PathVariable("name") String name) throws Exception{
        List<Librarian> librarians = librarianService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Data by Name",librarians)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable("id") Integer id) throws Exception{
        Optional<Librarian> librarian = librarianService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get librarian by id",librarian));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@RequestBody LibrarianRequest librarianRequest,@PathVariable("id") Integer id) throws Exception{
        Librarian librarian = modelMapper.map(librarianRequest,Librarian.class);
        librarianService.update(librarian,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Librarian by id",librarian));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) throws Exception{
        librarianService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Delete Data",null));
    }
}
