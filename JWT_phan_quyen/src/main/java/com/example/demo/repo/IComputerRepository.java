package com.example.demo.repo;

import com.example.demo.model.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComputerRepository extends JpaRepository<Computer, Long> {
}
