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

        // Open a connection to the URL with HttpURLConnection
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response from the API with bufferedreader, reading the JSON response, appending each line to
        // a stringbuilder, to create the complete json response
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Close the connection
        connection.disconnect();
        //SOUTing the full response, so we can inspect what we'd wanna see when we format the data
        System.out.println(response.toString());
        // Parse the JSON response so we can return the response as a parameter in another function.
        JSONObject jsonResponse = new JSONObject(response.toString());

        // Format and return the weather data
        return formatWeatherData(jsonResponse);
    }
    // this method takes a JSONObject, that represents the parsed data from getWeatherData
    //it extracts and formats weather information.
    public static String formatWeatherData(JSONObject jsonResponse) {
        // Extract and format relevant weather information
        String cityName = jsonResponse.getString("name");
        //this extracts a JSON object from the jsonResponse, allowing us to work with the data from the response
        JSONObject main = jsonResponse.getJSONObject("main");
        JSONObject wind = jsonResponse.getJSONObject("wind");
        JSONObject clouds = jsonResponse.getJSONObject("clouds");
        JSONObject sys = jsonResponse.getJSONObject("sys");

        //kelvin to temp, OpenWeatherMap APi uses kelvin as baseline
        // C = K - 273.15
        double temperature = main.getDouble("temp");
        double c = temperature - 273.15;
        double tempMax = main.getDouble("temp_max");
        double tempMaxC = tempMax - 273.15;
        double tempMin = main.getDouble("temp_min");
        double tempMinC = tempMin - 273.15;
        int humidity = main.getInt("humidity");
        double windspeed = wind.getDouble("speed");
        int cloud = clouds.getInt("all");
        int sunset = sys.getInt("sunset");



        StringBuilder formattedData = new StringBuilder();
        formattedData.append("Weather Data for ").append(cityName).append(":\n");
        formattedData.append("Temperature: ").append(c).append("°C\n");
        formattedData.append("Temperature Max: ").append(tempMaxC).append("°C\n");
        formattedData.append("Temperature Min: ").append(tempMinC).append("°C\n");
        formattedData.append("Humidity: ").append(humidity).append("%\n");
        formattedData.append("Wind Speed: ").append(windspeed).append("m/s\n");
        formattedData.append("Clouds: ").append(cloud).append("\n");
        formattedData.append("Sunset: ").append(sunset).append("\n");



        return formattedData.toString();
    }
}