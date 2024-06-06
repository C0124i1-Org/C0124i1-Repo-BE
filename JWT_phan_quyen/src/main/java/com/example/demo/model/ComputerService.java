package com.example.demo.model;

import jakarta.persistence.*;

@Entity

public class ComputerService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;

    @Column(nullable = false)
    private int quantity;
}
