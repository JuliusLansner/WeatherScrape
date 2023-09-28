package org.example.DAO;

import java.util.List;

public interface IWeather {
    List<WeatherEntity> getAll();
    WeatherEntity getTomorrow();
    WeatherEntity getToday();

}
