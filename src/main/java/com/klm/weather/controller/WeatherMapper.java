package com.klm.weather.controller;

import com.klm.weather.model.Weather;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WeatherMapper {

    Weather toEntity(WeatherResource weatherResource);

    WeatherResource toWeatherResource(Weather weather);

}
