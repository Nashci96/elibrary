package com.enigmacamp.elibrary.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Integer id_publisher;
    @Column(name = "is_active",nullable = false)
    private Integer is_active;
    @Column(name = "publisher_name",nullable = false)
    private String publisher_name;
    @Column(name = "publisher_address")
    private String publisher_address;
    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private List<Book> bookList;

//    @Override
//    public String toString() {
//        return "Publisher{" +
//                "id_publisher=" + id_publisher +
//                ", is_active=" + is_active +
//                ", publisher_name='" + publisher_name + '\'' +
//                ", pubisher_address='" + publisher_address + '\'' +
////                ", bookList=" + bookList +
//                '}';
//    }

    public Integer getId_publisher() {
        return id_publisher;
    }

    public void setId_publisher(Integer id_publisher) {
        this.id_publisher = id_publisher;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getPublisher_address() {
        return publisher_address;
    }

    public void setPublisher_address(String publisher_address) {
        this.publisher_address = publisher_address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
