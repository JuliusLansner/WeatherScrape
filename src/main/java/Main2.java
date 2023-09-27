import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.example.api.WeatherAPIM;

public class Main2 {
    private static String APIKey = "77ce734912f5dc35cd073874248b00e5";
    private static final String API_KEY = "0a3a70bed9265478574e462275fbbf69";
    public static void main(String[] args) {

       JsonObject jsonObject = WeatherAPIM.getWeatherGson(API_KEY,"Copenhagen");
        System.out.println(jsonObject);


    }
}
