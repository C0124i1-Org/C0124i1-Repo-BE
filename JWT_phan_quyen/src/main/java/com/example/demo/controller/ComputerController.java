package com.example.demo.controller;
import com.example.demo.model.Computer;
import com.example.demo.model.DTO.ComputerDTO;
import com.example.demo.repo.IComputerRepository;
import com.example.demo.service.computerService.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/computer")
public class ComputerController {
    @Autowired
    private IComputerService computerService;

    @Autowired
    private IComputerRepository computerRepository;

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
    public ResponseEntity<Computer> createComputer(@RequestBody ComputerDTO computerDTO) {
        Computer computer = new Computer();
        computer.setName(computerDTO.getName());
        computer.setStatus(false);
        computer.setUsageTime(0.0f);
        computer.setServiceCost(0.0f);
        computer.setTotalCost(0.0f);

        Computer savedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(savedComputer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputerName(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        Optional<Computer> optionalComputer = computerRepository.findById(id);
        if (!optionalComputer.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Computer computer = optionalComputer.get();
        if (updates.containsKey("name")) {
            computer.setName(updates.get("name"));
        }

        final Computer updatedComputer = computerRepository.save(computer);
        return ResponseEntity.ok(updatedComputer);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> delete(@PathVariable Long id) {
        computerService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
    @GetMapping("/exists")
    public ResponseEntity<Boolean> checkNameExists(@RequestParam String name) {
        boolean exists = computerRepository.existsByName(name);
        return ResponseEntity.ok(exists);
    }
}
