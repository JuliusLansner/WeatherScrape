import org.example.DAO.GetToday;
import org.example.DAO.WeatherEntity;
import org.example.DAO.GetTomorrow;

public class MainTomorrow {
    public static void main(String[] args) {
        GetTomorrow getTomorrow = new GetTomorrow();
        WeatherEntity tomorrow = getTomorrow.getTomorrow();
        System.out.println(tomorrow);


    }
}




