package org.example;


import org.example.Scraping.Location;
import org.example.Scraping.Temp;

public class Main {
    public static void main(String[] args) {
   Temp temp = new Temp();
 System.out.println(temp.tempList());
        Location loc = new Location();
        System.out.println(loc.locationList());

    }
}