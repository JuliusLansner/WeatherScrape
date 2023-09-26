package org.example.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class WeatherApiClient {
    private static final String API_KEY = "0a3a70bed9265478574e462275fbbf69"; // Replace with your OpenWeatherMap API key

    public static void main(String[] args) {
        String city = "Hillerød"; // Replace with the city you want to get weather data for
        try {
            String weatherData = getWeatherData(city);
            System.out.println("Weather Data:\n" + weatherData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getWeatherData(String city) throws Exception {
        // Create a URL for the API request
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + API_KEY;
        URL url = new URL(apiUrl);

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response from the API
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Close the connection
        connection.disconnect();

        // Parse the JSON response
        JSONObject jsonResponse = new JSONObject(response.toString());

        // Format and return the weather data
        return formatWeatherData(jsonResponse);
    }

    public static String formatWeatherData(JSONObject jsonResponse) {
        // Extract and format relevant weather information
        String cityName = jsonResponse.getString("name");
        JSONObject main = jsonResponse.getJSONObject("main");
        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");

        StringBuilder formattedData = new StringBuilder();
        formattedData.append("Weather Data for ").append(cityName).append(":\n");
        formattedData.append("Temperature: ").append(temperature).append("°C\n");
        formattedData.append("Humidity: ").append(humidity).append("%\n");

        return formattedData.toString();
    }
}