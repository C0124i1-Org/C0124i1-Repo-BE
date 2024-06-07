package com.example.demo.controller;
import com.example.demo.model.Computer;
import com.example.demo.service.computerService.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/computer")
public class ComputerController {
    @Autowired
    private IComputerService computerService;

    @GetMapping("")
    public ResponseEntity<List<Computer>> findAll() {
        return new ResponseEntity<>(computerService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Computer> findOne(@PathVariable Long id) {
        Computer c = computerService.findOne(id);
        return new ResponseEntity<>(computerService.findOne(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> save(@RequestBody Computer computer) {
        computerService.save(computer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Computer customer) {
        Computer existingCustomer = computerService.findOne(id);
        if (existingCustomer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        customer.setId(id);
        computerService.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        computerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
