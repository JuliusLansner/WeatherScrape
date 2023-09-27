package org.example;


import org.example.DTO.WeatherDTO;
import org.example.Scraping.*;
import org.example.api.WeatherAPIM;
import org.jsoup.select.Elements;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<WeatherDTO> weatherthings = ScrapingTools.DTOMaker();

        System.out.println(weatherthings);
    }
}