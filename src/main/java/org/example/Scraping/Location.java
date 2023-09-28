package org.example.Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.select.Elements;

import java.io.IOException;


public class Location implements ILocation {
    /**
     * Location class is responsible for scraping the location information of a given url.
     */
    @Override
    public String locationList() {
        String url = "https://www.accuweather.com/en/dk/hiller%C3%B8d/123048/daily-weather-forecast/123048";
        String locationText;

        /**
         * @return returns locationtext, which is a text formatted element extracted using JSoup functionality
         */
        try {
            final Document document = Jsoup.connect(url).get();

            Elements loc = document.select(".header-loc");
            locationText = loc.text();
            return locationText;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
