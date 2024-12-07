package com.klm.weather.service;

import com.klm.weather.controller.WeatherMapper;
import com.klm.weather.controller.WeatherResource;
import com.klm.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Transactional
    public WeatherResource create(WeatherResource weatherResource) {
        return weatherMapper.toWeatherResource(weatherRepository.save(weatherMapper.toEntity(weatherResource)));
    }

    public List<WeatherResource> findAll() {
        return weatherMapper.toWeatherResources(weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

}
