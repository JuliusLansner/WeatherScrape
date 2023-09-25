package org.example.Scraping;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Description implements IDescription {

    private static final String url = "https://www.accuweather.com/en/dk/hiller%C3%B8d/123048/daily-weather-forecast/123048";
    private static final String cssSelector = "div.phrase";

    public static void main(String[] args) {
        new Description().descList();
    }

    @Override
    public List<String> descList() {
        List<String> descriptionList = new ArrayList<>();
        Elements descriptions = GetElements.getElements(url, cssSelector);

        for (Element description : descriptions) {
            String text = description.text();
            descriptionList.add(text);
        }

        for (String desc : descriptionList) {
            System.out.println("Description: " + desc);
            System.out.println("----------");
        }
        return descriptionList;
    }
}