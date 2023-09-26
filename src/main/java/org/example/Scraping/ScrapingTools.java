package org.example.Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
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
}
