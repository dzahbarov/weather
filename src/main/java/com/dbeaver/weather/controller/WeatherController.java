package com.dbeaver.weather.controller;

import com.dbeaver.weather.domain.Weather;
import com.dbeaver.weather.service.WeatherService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;

/**
 * @author dzahbarov
 */

@RestController
@RequestMapping("weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public Weather getWeather() throws IOException {
        Weather weather = weatherService.findByDate(LocalDate.now());
        if (weather == null) {
            Document doc = Jsoup.connect("http://yandex.ru").get();
            String temp = doc.select(".weather__temp").first().html();
            weather = new Weather();
            weather.setDate(LocalDate.now());
            weather.setValue(temp);
            weatherService.save(weather);
        }
        return weather;
    }

}
