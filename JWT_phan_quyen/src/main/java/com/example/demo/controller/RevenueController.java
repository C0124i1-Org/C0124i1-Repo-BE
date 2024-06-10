package com.example.demo.controller;

import com.example.demo.model.DTO.TimeRange;
import com.example.demo.model.Revenue;
import com.example.demo.service.revenueService.IRevenueService;
import com.example.demo.service.revenueService.RevenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/revenue")
public class RevenueController {
    @Autowired
    private RevenueService revenueService;
@GetMapping("")
    public Float getTotalRevenue(){
    return revenueService.getTotalRevenue();
}

//@PostMapping("/time")
//    public ResponseEntity<List<Revenue>> findRevenueBetween(@RequestParam String start,@RequestParam String end){
//    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//    LocalDateTime startTime = LocalDateTime.parse(start,formatter);
//    LocalDateTime endTime = LocalDateTime.parse(end,formatter);
//    List<Revenue> revenues = revenueService.getRevenueComputerBetween(startTime,endTime);
//    return new ResponseEntity<>(revenues,HttpStatus.OK);
//
//}
@PostMapping("/time")
public ResponseEntity<List<Revenue>> findRevenueBetween(@RequestBody TimeRange timeRange) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    try {

        LocalDateTime startTime = LocalDateTime.parse(timeRange.getStart(), formatter);
        LocalDateTime endTime = LocalDateTime.parse(timeRange.getEnd(), formatter);

        List<Revenue> revenues = revenueService.getRevenueComputerBetween(startTime, endTime);
        return new ResponseEntity<>(revenues, HttpStatus.OK);
    } catch (DateTimeParseException e) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

}
