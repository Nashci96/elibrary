package com.enigmacamp.elibrary.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Integer id_member;
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
        return "Member{" +
                "id_member=" + id_member +
                ", is_active=" + is_active +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId_member() {
        return id_member;
    }

    public void setId_member(Integer id_member) {
        this.id_member = id_member;
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
