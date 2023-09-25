package org.example;


import org.example.Scraping.Date;

public class Main {
    public static void main(String[] args) {
     Date date = new Date();

     date.dateList().forEach(string-> System.out.println(string));

    }
}