package com.klm.weather.controller;

import com.klm.weather.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@RequiredArgsConstructor
public class WeatherApiRestController {

    private final WeatherService weatherService;

    @PostMapping
    public ResponseEntity<WeatherResource> create(@RequestBody WeatherResource weatherResource) {
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherService.create(weatherResource));
    }

}
