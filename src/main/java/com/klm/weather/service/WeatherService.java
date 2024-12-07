package com.klm.weather.service;

import com.klm.weather.controller.WeatherMapper;
import com.klm.weather.controller.WeatherResource;
import com.klm.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Transactional
    public WeatherResource create(final WeatherResource weatherResource) {
        return weatherMapper.toWeatherResource(weatherRepository.save(weatherMapper.toEntity(weatherResource)));
    }

    public List<WeatherResource> findAll(final Optional<Date> date) {
        if (date.isPresent()) {
            return weatherMapper.toWeatherResources(weatherRepository.findByDate(date.get()));
        }
        return findAll();
    }

    private List<WeatherResource> findAll() {
        return weatherMapper.toWeatherResources(weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

}
