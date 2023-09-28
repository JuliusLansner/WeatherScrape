package org.example.DAO;

import org.example.Entities.WeatherEntity;

import java.util.List;

public interface IWeather {
    List<WeatherEntity> getAll();
    WeatherEntity getTomorrow();
    WeatherEntity getToday();

}
