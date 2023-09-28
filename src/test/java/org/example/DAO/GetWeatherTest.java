package org.example.DAO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetWeatherTest {
    public GetWeather tomorrow;
    @BeforeEach
    public void setUp(){
        tomorrow = new GetWeather();
    }
    @Test
    void getTomorrow() {
        WeatherEntity getTomorrow = tomorrow.getTomorrow();
        assertNotNull(getTomorrow);
        assertFalse(getTomorrow==null);
    }
}