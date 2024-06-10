package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
    @Data

    public class Service {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(nullable = false)
        private String name;

        @Column(nullable = false)
        private float cost;
        @OneToMany(mappedBy = "service", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ComputerService> computerServices;
    }

