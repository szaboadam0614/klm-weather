package com.klm.weather.service;

import com.klm.weather.controller.WeatherMapper;
import com.klm.weather.controller.WeatherResource;
import com.klm.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Transactional
    public WeatherResource create(WeatherResource weatherResource) {
        return weatherMapper.toWeatherResource(weatherRepository.save(weatherMapper.toEntity(weatherResource)));
    }

}
