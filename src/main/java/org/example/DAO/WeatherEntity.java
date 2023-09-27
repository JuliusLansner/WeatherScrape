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
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weather_id")
    private int id;
    @Column(name = "city_name")
    private String cityName;
    @Column(name = "date")
    private String date;
    @Column(name = "location")
    private String location;
    @Column(name = "lowtemp")
    private String lowTemp;
    @Column(name = "hightemp")
    private String highTemp;
    @Column(name = "description")
    private String description;
    @Column(name = "temp")
    private String temp;
    @Column(name = "humidity")
    private int humidity;
    @Column(name = "windspeed")
    private double windSpeed;
}
