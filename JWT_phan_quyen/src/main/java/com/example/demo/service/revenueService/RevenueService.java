package com.example.demo.service.revenueService;

import com.example.demo.model.Revenue;
import com.example.demo.repo.IRevenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RevenueService implements IRevenueService {
    @Autowired
    private IRevenueRepository revenueRepository;

    @Override
    public Float getTotalRevenue() {
        List<Revenue> revenues = revenueRepository.findAll();
        float totalRevenue = 0;
        for( Revenue revenue: revenues){
            totalRevenue += revenue.getTotalRevenue();
        }
        return totalRevenue;
    }

    @Override
    public List<Revenue> getRevenueComputerBetween(LocalDateTime startTime, LocalDateTime endTime) {
        return revenueRepository.findByStartTimeBetween(startTime, endTime);
    }
}
