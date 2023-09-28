package org.example.DAO;

import org.example.Entities.DailyWeatherEntity;
import org.example.Entities.WeatherEntity;

import java.util.List;

public interface IWeather {
    List<DailyWeatherEntity> getAll();

    WeatherEntity getTomorrow();

    WeatherEntity getToday();

}
