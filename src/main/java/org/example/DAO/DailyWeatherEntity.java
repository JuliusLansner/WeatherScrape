package org.example.DAO;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class DailyWeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private int id;
    //scraping:
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "temp")
    private String temp;
    //api:
    @Column(name = "humidity")
    private String humidity;
    @Column(name = "windspeed")
    private String windSpeed;

    public DailyWeatherEntity(String location, String date, String description, String temp, String humidity, String windSpeed) {
        this.location = location;
        this.date = date;
        this.description = description;
        this.temp = temp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }
}
