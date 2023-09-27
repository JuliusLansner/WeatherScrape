package org.example.api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherAPIM {
    public static JsonObject getWeatherGson(String APIKey,String city) {
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        JsonObject jsonObject = null;

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("appid",APIKey);
        urlBuilder.addQueryParameter("q",city);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url).get()
                .build();

        try {
            response = client.newCall(request).execute();
            String responseBody = response.body().string();
            Gson gson = new Gson();
            jsonObject = gson.fromJson(responseBody,JsonObject.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return jsonObject;
    }
}
