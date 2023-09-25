package org.example.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter

public class WeatherDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String date;
    String location;
    String lowTemp;
    String highTemp;
    String description;

    public WeatherDTO(String date, String location, String lowTemp, String highTemp, String description) {
        this.date = date;
        this.location = location;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
        this.description = description;
    }
}