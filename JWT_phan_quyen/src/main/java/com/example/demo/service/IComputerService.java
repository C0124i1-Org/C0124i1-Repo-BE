package com.example.demo.service;
import com.example.demo.model.Computer;

import java.util.List;

public interface IComputerService {
    List<Computer> findAll();

    Computer findOne(Long id);

    void save(Computer computer);

    void deleteById(Long id);
}