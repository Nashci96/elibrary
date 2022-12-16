package com.enigmacamp.elibrary.service.implementation;

import com.enigmacamp.elibrary.exception.EntityExistException;
import com.enigmacamp.elibrary.exception.NotFoundException;
import com.enigmacamp.elibrary.model.entity.Book;
import com.enigmacamp.elibrary.model.entity.Publisher;
import com.enigmacamp.elibrary.model.request.BookRequest;
import com.enigmacamp.elibrary.repository.BookRepo;
import com.enigmacamp.elibrary.repository.PublisherRepo;
import com.enigmacamp.elibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private PublisherRepo publisherRepo;

    @Override
    public List<Book> listByActive() throws Exception {
        List<Book> result = bookRepo.getListActive();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Book> listAll() throws Exception {
        List<Book> result = bookRepo.findAll();
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public List<Book> listByName(String name) throws Exception {
        List<Book> result = bookRepo.getListByName(name);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public Book create(BookRequest book) throws Exception {
        try {
            Book newBook = new Book();
            newBook.setTitle(book.getTitle());
            newBook.setAuthor(book.getAuthor());
            newBook.setIs_active(1);
            newBook.setYear_published(book.getYear_published());
            newBook.setPublished_at(book.getPublished_at());

            Optional<Publisher> publisher = publisherRepo.findById(book.getId_publisher());

            if (publisher.isEmpty()){
                throw new NotFoundException("Publisher Not Found");
            }

            newBook.setPublisher(publisher.get());
            Book bookRepository = bookRepo.save(newBook);
            return bookRepository;
        } catch (DataIntegrityViolationException e){
            throw new EntityExistException();
        }
    }

    @Override
    public Optional<Book> getById(Integer id) throws Exception {
        Optional<Book> result = bookRepo.findById(id);
        if (result.isEmpty()){
            throw new NotFoundException();
        }
        return result;
    }

    @Override
    public void update(Book book, Integer id) throws Exception {
        try {
            Optional<Book> existingBook = getById(id);
            if (existingBook.isPresent()){
                book.setId_book(id);
                bookRepo.save(book);
            }
        } catch (Exception e) {
            throw new NotFoundException("Book Not Found");
        }
    }

    @Override
    public void delete(Integer id) throws Exception {
        try {
            Optional<Book> existingBook = getById(id);
            bookRepo.delete(existingBook.get());
        } catch (Exception e) {
            throw new NotFoundException("Delete Failed because id not found");
        }
    }
}
