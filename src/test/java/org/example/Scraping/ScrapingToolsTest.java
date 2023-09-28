package org.example.Scraping;

import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScrapingToolsTest {


    @Test
    public void testGetElements() {
        Elements elements = ScrapingTools.getElements("http://quotes.toscrape.com/", "div.quote");
        String albertquote = "“The world as we have created it is a process of our thinking. It cannot be changed without changing our thinking.” by Albert Einstein (about) Tags: change deep-thoughts thinking world";
        assertEquals(elements.first().text(), albertquote);
    }




}