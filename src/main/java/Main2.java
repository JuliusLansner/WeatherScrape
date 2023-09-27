import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.DAO.DailyWeatherEntity;
import org.example.DAO.WeatherEntity;
import org.example.DTO.WeatherDTO;
import org.example.Scraping.ScrapingTools;
import org.example.api.WeatherAPIM;
import org.example.config.HibernateConfig;

import java.util.List;

public class Main2 {
<<<<<<< Updated upstream
    private static String APIKey = "77ce734912f5dc35cd073874248b00e5";
    private static final String API_KEY = "0a3a70bed9265478574e462275fbbf69";
    public static void main(String[] args) {

       JsonObject jsonObject = WeatherAPIM.getWeatherGson(API_KEY,"Copenhagen");
        System.out.println(jsonObject);
=======
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public static void main(String[] args) {
        List<WeatherDTO> weatherthings = ScrapingTools.DTOMaker();
        JsonObject JsonObjectapi = WeatherAPIM.getWeatherGson("0a3a70bed9265478574e462275fbbf69", "Copenhagen");
        JsonObject JsonObjectMain = JsonObjectapi.getAsJsonObject("main");
        JsonObject JsonObjectWind = JsonObjectapi.getAsJsonObject("wind");
        String hum = JsonObjectMain.get("humidity").toString();
        String wind = JsonObjectWind.get("speed").toString();


        for (WeatherDTO weatherDTO: weatherthings){
            DailyWeatherEntity weatherEntity = new DailyWeatherEntity(weatherDTO.getLocation(),weatherDTO.getDate(),weatherDTO.getDescription(),weatherDTO.getTemp(),hum,wind);
            try(EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                em.persist(weatherEntity);
                em.getTransaction().commit();
            }
        }
>>>>>>> Stashed changes


    }
}
