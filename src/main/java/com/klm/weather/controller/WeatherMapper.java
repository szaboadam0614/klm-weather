package com.klm.weather.controller;

import com.klm.weather.model.Weather;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    Weather toEntity(WeatherResource weatherResource);

    WeatherResource toWeatherResource(Weather weather);

    List<WeatherResource> toWeatherResources(List<Weather> weathers);

}
