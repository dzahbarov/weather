package com.dbeaver.weather.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author dzahbarov
 */

@Entity
@Getter
@Setter
public class Weather {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "weather_date")
    private LocalDate date;

    @Column(name = "weather_value")
    private String value;
}
