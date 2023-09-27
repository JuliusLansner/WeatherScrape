package org.example.DAO;

import java.util.List;

public interface IWeather {
    List<WeatherEntity> getAll();
    String getTomorrow();
    String getSpecificDate();

}
