import org.example.DAO.GetToday;
import org.example.DAO.WeatherEntity;
import org.example.DAO.GetTomorrow;

public class MainTomorrow {
    public static void main(String[] args) {
        GetTomorrow getTomrrorw = new GetTomorrow();
        WeatherEntity tomorrow = getTomrrorw.getTomorrow();
        System.out.println(tomorrow);


    }
}




