package org.example.api;

import java.io.IOException;

public class weatherAPIM {
    public static JsonObject getWeatherGson(String APIKey, String lat, String lon) {
        OkHttpClient client = new OkHttpClient();
        Response response = null;
        JsonObject jsonObject = null;

        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://api.openweathermap.org/data/2.5/weather?").newBuilder();
        urlBuilder.addQueryParameter("appid",APIKey);
        urlBuilder.addQueryParameter("lat",lat);
        urlBuilder.addQueryParameter("lon",lon);
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
