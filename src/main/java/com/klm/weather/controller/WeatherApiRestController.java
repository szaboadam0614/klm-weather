package com.klm.weather.controller;

import com.klm.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherApiRestController {

    private final WeatherService weatherService;

    @PostMapping
    public ResponseEntity<WeatherResource> create(@RequestBody WeatherResource weatherResource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.create(weatherResource));
    }

    @GetMapping
    public ResponseEntity<List<WeatherResource>> getAll() {
        return ResponseEntity.ok(weatherService.findAll());
    }

}
