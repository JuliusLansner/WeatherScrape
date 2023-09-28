package org.example.Entities;

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
    @Column(name = "location")
    private String location;
    @Column(name = "date")
    private String date;
    @Column(name = "description")
    private String description;
    @Column(name = "temp")
    private String temp;

    public WeatherEntity(String location, String date, String description, String temp) {
        this.location = location;
        this.date = date;
        this.description = description;
        this.temp = temp;
    }
}
