package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Boolean status ;

    @Column(nullable = false)
    private float usageTime = 0.0f;

    @Column(nullable = false)
    private float serviceCost = 0.0f;

    @Column(nullable = false)
    private float totalCost = 0.0f;

    @JsonBackReference
    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Revenue> revenueEntries;

//    @JsonBackReference
//    @OneToMany(mappedBy = "computer", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<ComputerService> computerServices;


}

