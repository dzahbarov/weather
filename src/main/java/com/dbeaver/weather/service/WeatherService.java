package com.dbeaver.weather.service;

import com.dbeaver.weather.domain.Weather;
import com.dbeaver.weather.repository.WeatherRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


/**
 * @author dzahbarov
 */

@Service
public class WeatherService {
    private WeatherRepository weatherRepository;

    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    public Weather findByDate(LocalDate date) {
        return weatherRepository.findByDate(date);
    }

    public Weather save(Weather weather) {
        return weatherRepository.save(weather);
    }
}
