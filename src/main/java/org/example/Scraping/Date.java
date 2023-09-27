package org.example.Scraping;

import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class Date implements IDate {

    @Override
    public List<String> dateList() {
        Elements elements = ScrapingTools.getElements("https://www.accuweather.com/en/dk/hiller%C3%B8d/123048/daily-weather-forecast/123048", "h2.date span.module-header.sub.date");
        List<String> dates = elements
                .stream()
                .map(element -> element.text())
                .collect(Collectors.toList());
        return dates;
    }
}
