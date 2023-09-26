package org.example.Scraping;

import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * The Description class is responsible for scraping daily weather descriptions from a website.
 */
public class Description implements IDescription {

    private final String url = "https://www.accuweather.com/en/dk/hiller%C3%B8d/123048/daily-weather-forecast/123048";
    // CSS selector for the weather description
    private final String cssSelector = "div.phrase";

    /**
     * The descList method scrapes the daily weather descriptions from a website and returns them as a list of string.
     *
     * @return A list of daily weather descriptions.
     */
    @Override
    public List<String> descList() {
        List<String> descriptionList = new ArrayList<>();
        Elements descriptions = ScrapingTools.getElements(url, cssSelector);

        descriptions.forEach(description -> {
            String text = description.text();
            descriptionList.add(text);
        });
        return descriptionList;
    }
}