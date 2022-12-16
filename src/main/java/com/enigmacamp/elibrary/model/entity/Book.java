package com.enigmacamp.elibrary.model.entity;
import javax.persistence.*;

@Entity
@Table(name = "t_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Integer id_book;
    @Column(name = "is_active",nullable = false)
    private Integer is_active;
    @Column(name = "title",nullable = false)
    private String title;
    @Column(name = "author")
    private String author;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
    @Column(name = "year_published")
    private String year_published;
    @Column(name = "published_at")
    private String published_at;

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id_book=" + id_book +
//                ", is_active=" + is_active +
//                ", title='" + title + '\'' +
//                ", author='" + author + '\'' +
//                ", publisher=" + publisher +
//                ", year_published='" + year_published + '\'' +
//                ", published_at='" + published_at + '\'' +
//                '}';
//    }

    public Integer getId_book() {
        return id_book;
    }

    public void setId_book(Integer id_book) {
        this.id_book = id_book;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getYear_published() {
        return year_published;
    }

    public void setYear_published(String year_published) {
        this.year_published = year_published;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }
}
