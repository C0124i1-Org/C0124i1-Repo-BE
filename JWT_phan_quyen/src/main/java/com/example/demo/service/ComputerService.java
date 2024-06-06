package com.example.demo.service;

import com.example.demo.model.Computer;
import com.example.demo.repo.IComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository computerRepository;

    @Override
    public List<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Computer findOne(Long id) {
        return computerRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Computer customer) {
        computerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        computerRepository.deleteById(id);
    }
}
