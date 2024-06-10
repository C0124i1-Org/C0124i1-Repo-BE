package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {

}