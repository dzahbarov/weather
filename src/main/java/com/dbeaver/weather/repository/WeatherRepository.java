package com.dbeaver.weather.repository;

import com.dbeaver.weather.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @author dzahbarov
 */

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {
    Weather findByDate(LocalDate date);
}
