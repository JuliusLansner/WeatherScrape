package org.example.Scraping;

import org.jsoup.select.Elements;

import java.util.List;
import java.util.stream.Collectors;

public class Date implements IDate {

    @Override
    public List<String> dateList() {
        Elements elements = ScrapingTools.getElements("https://www.accuweather.com/en/dk/copenhagen/123094/daily-weather-forecast/123094", "h2.date span.module-header.sub.date");
        List<String> dates = elements
                .stream()
                .map(element -> element.text())
                .collect(Collectors.toList());
        return dates;
    }
}
