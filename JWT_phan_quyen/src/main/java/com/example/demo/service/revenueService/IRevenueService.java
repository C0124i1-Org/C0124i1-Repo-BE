package com.example.demo.service.revenueService;

import com.example.demo.model.Computer;
import com.example.demo.model.Revenue;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface IRevenueService {
   Float getTotalRevenue();
    List<Revenue> getRevenueComputerBetween(LocalDateTime startTime, LocalDateTime endTime);
}
