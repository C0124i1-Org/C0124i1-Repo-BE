package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Revenue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private float totalRevenue;

    @Column(nullable = false)
    private LocalDateTime startTime = LocalDateTime.now();

    @Column(nullable = false)
    private LocalDateTime endTime = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "computer_id", nullable = false)
    private Computer computer;

}
