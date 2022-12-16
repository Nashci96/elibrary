package com.enigmacamp.elibrary.model.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "t_borrow")
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id")
    private Integer id_borrow;
    @Column(name = "is_active",nullable = false)
    private Integer is_active;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book books;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "librarian_id")
    private Librarian librarian;
    @Column(name = "date_reserved",nullable = false)
    private Date date_reserved;
    @Column(name = "date_returne",nullable = false)
    private Date date_returned;

    @OneToOne(mappedBy = "borrow")
    private Fine fine;

    public Integer getId_borrow() {
        return id_borrow;
    }

    public void setId_borrow(Integer id_borrow) {
        this.id_borrow = id_borrow;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public Book getBooks() {
        return books;
    }

    public void setBooks(Book books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Librarian getLibrarian() {
        return librarian;
    }

    public void setLibrarian(Librarian librarian) {
        this.librarian = librarian;
    }

    public Date getDate_reserved() {
        return date_reserved;
    }

    public void setDate_reserved(Date date_reserved) {
        this.date_reserved = date_reserved;
    }

    public Date getDate_returned() {
        return date_returned;
    }

    public void setDate_returned(Date date_returned) {
        this.date_returned = date_returned;
    }

    @Override
    public String toString() {
        return "Borrow{" +
                "id_borrow=" + id_borrow +
                ", is_active=" + is_active +
                ", books=" + books +
                ", member=" + member +
                ", librarian=" + librarian +
                ", date_reserved=" + date_reserved +
                ", date_returned=" + date_returned +
                '}';
    }
}
