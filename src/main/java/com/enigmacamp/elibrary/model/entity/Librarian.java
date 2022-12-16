package com.enigmacamp.elibrary.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_librarian")
public class Librarian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "librarian_id")
    private Integer id_librarian;
    @Column(name = "is_active",nullable = false)
    private Integer is_active;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "phone_number")
    private String phone_number;
    @Column(name = "email")
    private String email;

    @Override
    public String toString() {
        return "Librarian{" +
                "id_librarian=" + id_librarian +
                ", is_active=" + is_active +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId_librarian() {
        return id_librarian;
    }

    public void setId_librarian(Integer id_librarian) {
        this.id_librarian = id_librarian;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
