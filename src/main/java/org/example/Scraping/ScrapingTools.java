package org.example.Scraping;

import org.example.DTO.WeatherDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScrapingTools {

    private static Document makeDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

    public static Elements getElements(String url, String cssSelector) {
        Document document = makeDocument(url);
        if (document != null) {
            return document.select(cssSelector);
        } else {

            return new Elements();
        }
    }


    public static List<WeatherDTO> DTOMaker() {
        List<WeatherDTO> DTOs = new ArrayList<>();

        Temp temp = new Temp();
        Description description = new Description();
        Location location = new Location();
        Date date = new Date();

        List<String> tempatures = temp.tempList();
        List<String> descriptions = description.descList();
        String locatione = location.locationList();
        List<String> dates = date.dateList();

        for (int i = 0; i < date.dateList().size(); i++) {
            WeatherDTO weatherDTO = new WeatherDTO(dates.get(i), locatione, descriptions.get(i), tempatures.get(i));
            System.out.println(weatherDTO);
            DTOs.add(weatherDTO);
        }
        return DTOs;
    }

    public static List<WeatherDTO> DTOMakerThread() {
        List<WeatherDTO> DTOs = new ArrayList<>();

        Temp temp = new Temp();
        Description description = new Description();
        Location location = new Location();
        Date date = new Date();

        List<String> tempatures = new ArrayList<>();
        Thread thread1 = new Thread(() -> {
            tempatures.addAll(temp.tempList());
        });

        List<String> descriptions = new ArrayList<>();
        Thread thread2 = new Thread(() -> {
            descriptions.addAll(description.descList());
        });

        List<String> dates = new ArrayList<>();
        Thread thread3 = new Thread(() -> {
            dates.addAll(date.dateList());
        });

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < dates.size(); i++) {
            String locatione = location.locationList();
            WeatherDTO weatherDTO = new WeatherDTO(dates.get(i), locatione, descriptions.get(i), tempatures.get(i));
            System.out.println(weatherDTO);
            DTOs.add(weatherDTO);
        }
        return DTOs;
    }

}
