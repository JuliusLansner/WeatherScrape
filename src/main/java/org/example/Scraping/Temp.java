package org.example.Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//testing
//  Temp temp = new Temp();
//        System.out.println(temp.tempList());
public class Temp implements ITemp{
    @Override
    public List<String> tempList() {
        String url = "https://www.accuweather.com/en/dk/hiller%C3%B8d/123048/daily-weather-forecast/123048";
        List<String> htlt;
        try {
            final Document document = Jsoup.connect(url).get();
            htlt = new ArrayList<>();

            Elements temps = document.select(".temp");
            for (Element t : temps) {
                String highTemps = t.select(".high").text().replace("°","");
                String lowTemps = t.select(".low").text().replace("°","").replace("/","");
                String combined = highTemps +"/"+ lowTemps;
                htlt.add(combined);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return htlt;
    }
}

