package com.example.demo.controller;

import com.example.demo.model.Service;
import com.example.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @PostMapping("/create")
    public ResponseEntity<?> addService(@RequestBody Service service) {
        Service newService = serviceService.addService(service);
        return ResponseEntity.ok(newService);
    }

    // Các phương thức khác cho việc truy vấn và cập nhật dịch vụ
}
