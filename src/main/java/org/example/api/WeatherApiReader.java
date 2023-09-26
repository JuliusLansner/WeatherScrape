package org.example.api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * The WeatherApiReader class holds methods for fetching weather data from OpenWeatherMap API.
 */
public class WeatherApiReader {

    private final String apiKey = "0a3a70bed9265478574e462275fbbf69";

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        String location = "Copenhagen";
        System.out.println(new WeatherApiReader().weatherAPIInfo(location));
    }

    /**
     * The weatherAPIInfo method fetches weather information for a chosen location.
     *
     * @param location The name of the location where information is wanted.
     * @return A string containing humidity and cloudiness for a given city.
     */
    public String weatherAPIInfo(String location) {
        try {
            URI uri = new URI("https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey);
            // Build the HTTP request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            // Send the HTTP request and get a response as a string
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the response string into a JsonObject
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject mainObject = jsonObject.getAsJsonObject("main");
            JsonObject cloudObject = jsonObject.getAsJsonObject("clouds");
            double humidity = mainObject.get("humidity").getAsDouble();
            double cloudiness = cloudObject.get("all").getAsDouble();

            String humidityAndUVInfo = "Humidity: " + humidity + " %\n" + "Cloudiness: " + cloudiness + " %";
            return humidityAndUVInfo;
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException("Error fetching data");
        }
    }
}