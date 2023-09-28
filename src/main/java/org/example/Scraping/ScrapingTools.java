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

/**
 * A class with some basic tools for webscraping to get rid of some boilerplate code.
 */
public class ScrapingTools {

    /**
     *
     * @param url Url for website
     * @return A HTML document representet as a Document object
     */

    private static Document makeDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {

            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param url Website to scrape from
     * @param cssSelector CssSelector for scraping the website
     * @return Elements from the site in object of Elements
     */
    public static Elements getElements(String url, String cssSelector) {
        Document document = makeDocument(url);
        if (document != null) {
            return document.select(cssSelector);
        } else {

            return new Elements();
        }
    }

    /**
     * Uses classes Temp, Description, Location and Date, and their functions tempList, descList,
     * locationList, dateList which each returns a list of tempatures, descriptions of weather, location of weather, date of weather
     * And from these lists, create weather DTO's which each represents the data of weather on a certain day.
     * @return A list of DTO WeatherDTO objects
     */
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
    /**
     * Same function as DTOMaker, but uses threads to speed the execution time up.
     *
     * Uses classes Temp, Description, Location and Date, and their functions tempList, descList,
     * locationList, dateList which each returns a list of tempatures, descriptions of weather, location of weather, date of weather
     * And from these lists, create weather DTO's which each represents the data of weather on a certain day.
     * @return A list of DTO WeatherDTO objects
     */
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
