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
    public ResponseEntity<List<WeatherResource>> getAllByParameters(@RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") final Optional<Date> date,
                                                                    @RequestParam(value = "city", required = false) final List<String> cities,
                                                                    @RequestParam(value = "sort", required = false) final Optional<String> sort) {
        return ResponseEntity.ok(weatherService.findAllByParameters(date, cities, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WeatherResource> getById(@PathVariable("id") final Integer id) {
        return ResponseEntity.ok(weatherService.findById(id));
    }

}
