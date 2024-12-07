package com.klm.weather.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_gen")
    @SequenceGenerator(name = "weather_gen", sequenceName = "weather_seq", allocationSize = 1)
    private Integer id;

    private Date date;

    private Float lat;
    private Float lon;
    private String city;
    private String state;

    private List<Double> temperatures;

    public Weather(Integer id, Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.id = id;
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

    public Weather(Date date, Float lat, Float lon, String city, String state, List<Double> temperatures) {
        this.date = date;
        this.lat = lat;
        this.lon = lon;
        this.city = city;
        this.state = state;
        this.temperatures = temperatures;
    }

}
