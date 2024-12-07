package com.klm.weather.repository;

import com.klm.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Integer> {

    @Query("""
            SELECT w FROM Weather w where
            CAST(w.date AS date) = :date
            ORDER BY w.id
            """)
    List<Weather> findByDate(@Param("date") Date date);

    @Query("""
            SELECT w FROM Weather w WHERE
            lower(w.city) IN :cities
            ORDER BY w.id
            """)
    List<Weather> findByCitiesIn(@Param("cities") List<String> cities);

    @Query("""
            SELECT w FROM Weather w WHERE
            CAST(w.date AS date) = :date
            AND lower(w.city) IN :cities
            ORDER BY w.id
            """)
    List<Weather> findByDateAndCities(@Param("date") Date date, @Param("cities") List<String> cities);

}
