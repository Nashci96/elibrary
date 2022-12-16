package com.enigmacamp.elibrary.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_fine")
public class Fine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fine_id")
    private Integer id_fine;
    @Column(name = "is_active",nullable = false)
    private Integer is_active;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "borrow_id")
    private Borrow borrow;
    @Column(name = "fine_cost")
    private Integer fineCost;
}
