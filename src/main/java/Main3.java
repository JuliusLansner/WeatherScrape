import org.example.DAO.GetToday;
import org.example.DAO.WeatherEntity;

public class Main3 {
    public static void main(String[] args) {
        GetToday getToday = new GetToday();
        WeatherEntity weatherEntity = getToday.getToday();
        System.out.println(weatherEntity);
    }
}
