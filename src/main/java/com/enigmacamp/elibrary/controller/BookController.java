package com.enigmacamp.elibrary.controller;

import com.enigmacamp.elibrary.model.entity.Book;
import com.enigmacamp.elibrary.model.request.BookRequest;
import com.enigmacamp.elibrary.model.response.CommonResponse;
import com.enigmacamp.elibrary.model.response.SuccessResponse;
import com.enigmacamp.elibrary.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ModelMapper modelMapper;
    @GetMapping("/all")
    public ResponseEntity<CommonResponse> getAllBook() throws Exception {
        List<Book> books = bookService.listAll();
        System.out.println(books);
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success get all book",books)
        );
    }

    @GetMapping
    public ResponseEntity getAllActiveBook() throws Exception{
        List<Book> books = bookService.listByActive();
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Book Data",books)
        );
    }

    @GetMapping("/list-by-name/{name}")
    public ResponseEntity getAllBookByName(@PathVariable("name") String name) throws Exception{
        List<Book> books = bookService.listByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(
                new SuccessResponse<>("Success Get All Book Data",books)
        );
    }

    @PostMapping
    public Book createBook(@RequestBody BookRequest book) throws Exception{
        try {
            Book result = bookService.create(book);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getId(@PathVariable("id") Integer id) throws Exception{
        Optional<Book> book = bookService.getById(id);
        return  ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success get Book with id",book));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateById(@RequestBody BookRequest bookRequest,@PathVariable("id") Integer id) throws Exception{
        Book book = modelMapper.map(bookRequest,Book.class);
        bookService.update(book,id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Update Book by id",book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) throws Exception{
        bookService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("Success Delete Book",null));
    }



}
