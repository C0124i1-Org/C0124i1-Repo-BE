package com.example.demo.repo;

import com.example.demo.model.Revenue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface IRevenueRepository extends JpaRepository<Revenue,Long> {
    List<Revenue> findByStartTimeBetween(LocalDateTime startTime, LocalDateTime endTime);

}
