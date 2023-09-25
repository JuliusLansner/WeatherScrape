package org.example.Scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class GetElements {
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
}
