package com.example.demo.service;

import com.example.demo.repo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceService implements IServiceService {

    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public com.example.demo.model.Service addService(com.example.demo.model.Service service) {
        return serviceRepository.save(service);
    }


    // Các phương thức khác cho việc truy vấn và cập nhật dịch vụ
}
