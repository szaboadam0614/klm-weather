package com.klm.weather.controller;

import java.util.Date;
import java.util.List;

public record WeatherResource(
        Integer id,
        Date date,
        Float lat,
        Float lon,
        String city,
        String state,
        List<Double> temperatures) {
}
