import org.example.DAO.GetWeather;
import org.example.Entities.WeatherEntity;

public class MainGetWeather {
    public static void main(String[] args) {
        GetWeather getToday = new GetWeather();
        WeatherEntity weatherEntity = getToday.getToday();
        System.out.println(weatherEntity);

        GetWeather getTomorrow = new GetWeather();
        WeatherEntity tomorrow = getTomorrow.getTomorrow();
        System.out.println(tomorrow);


    }
}
