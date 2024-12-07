package com.klm.weather.controller;

import com.klm.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<WeatherResource>> getAll(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Optional<Date> date) {
        return ResponseEntity.ok(weatherService.findAll(date));
    }

}
