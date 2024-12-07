package com.klm.weather.service;

import com.klm.weather.controller.WeatherMapper;
import com.klm.weather.controller.WeatherResource;
import com.klm.weather.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

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

    public List<WeatherResource> findAll(final Optional<Date> date, final List<String> cities) {
        if (date.isPresent() && !CollectionUtils.isEmpty(cities)) {
            return weatherMapper.toWeatherResources(weatherRepository.findByDateAndCities(date.get(), lower(cities)));
        }

        if (!CollectionUtils.isEmpty(cities)) {
            return weatherMapper.toWeatherResources(weatherRepository.findByCitiesIn(lower(cities)));
        }

        if (date.isPresent()) {
            return weatherMapper.toWeatherResources(weatherRepository.findByDate(date.get()));
        }
        return findAllWithoutFiltering();
    }

    private List<String> lower(final List<String> cities) {
        return cities.stream()
                .map(String::toLowerCase)
                .toList();
    }

    private List<WeatherResource> findAllWithoutFiltering() {
        return weatherMapper.toWeatherResources(weatherRepository.findAll(Sort.by(Sort.Direction.ASC, "id")));
    }

}
