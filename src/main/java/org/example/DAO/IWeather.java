package org.example.DAO;

import java.util.List;

public interface IWeather {
    List<DailyWeatherEntity> getAll();
    String getTomorrow();
    WeatherEntity getToday();

}
