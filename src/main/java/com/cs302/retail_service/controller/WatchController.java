package com.cs302.retail_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cs302.retail_service.model.Watch;
import com.cs302.retail_service.repository.WatchRepository;

import java.util.List;

@RestController
@RequestMapping("/api/watches")
public class WatchController {

    @Autowired
    private WatchRepository watchRepository;

    @GetMapping("/list")
    public List<Watch> getAllWatches() {
        return watchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Watch getWatchById(@PathVariable Long id) {
        return watchRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Watch not found"));
    }
}