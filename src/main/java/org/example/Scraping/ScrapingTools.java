package org.example.Scraping;

import org.example.DTO.WeatherDTO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

    public static String wordMatchGroup(String typedPattern,String searchMatch,int group){
        String match = null;

        Pattern pattern = Pattern.compile(typedPattern);
        Matcher matcher = pattern.matcher(searchMatch);
        while(matcher.find()){
            match = matcher.group(group);
        }
        return match;
    }

    public static String wordMatch(String typedPattern,String searchMatch){
        String match = null;

        Pattern pattern = Pattern.compile(typedPattern);
        Matcher matcher = pattern.matcher(searchMatch);
        while(matcher.find()){
            match = matcher.group();
        }
        return match;
    }

    public static List<WeatherDTO> DTOMaker(){
        List<WeatherDTO> DTOs = new ArrayList<>();

        Temp temp = new Temp();
        Description description = new Description();
        Location location = new Location();
        Date date = new Date();

        for (int i = 0; i < date.dateList().size(); i++) {
            List<String> tempatures = temp.tempList();
            List<String> descriptions = description.descList();
            String locatione = location.locationList();
            List<String> dates = date.dateList();
            WeatherDTO weatherDTO = new WeatherDTO(dates.get(i),locatione,descriptions.get(i), tempatures.get(i));
            System.out.println(weatherDTO);
            DTOs.add(weatherDTO);
        }
        return  DTOs;
    }

}
