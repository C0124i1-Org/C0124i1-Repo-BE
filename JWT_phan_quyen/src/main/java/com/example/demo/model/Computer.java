package com.example.demo.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Computer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(columnDefinition ="boolean default false" )
    private Boolean status ;  // Available or Disable

    @Column(nullable = false)
    private float usageTime = 0.0f;  // in hours

    @Column(nullable = false)
    private float serviceCost = 0.0f;

    @Column(nullable = false)
    private float totalCost = 0.0f;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Revenue> revenueEntries;

    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComputerService> computerServices;


}

