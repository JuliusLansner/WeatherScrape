package org.example.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter

public class WeatherDTO {
    private int id;
    String date;
    String location;
    String description;
    String temp;


    public WeatherDTO(String date, String location, String description, String temp) {
        this.date = date;
        this.location = location;
        this.description = description;
        this.temp = temp;

    }
}
