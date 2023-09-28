import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Entities.WeatherEntity;
import org.example.DTO.WeatherDTO;
import org.example.Scraping.*;
import org.example.config.HibernateConfig;

import java.util.List;


public class MainInsertWeatherEntity {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public static void main(String[] args) {
        List<WeatherDTO> weatherthings = ScrapingTools.DTOMakerThread();


        for (WeatherDTO weatherDTO: weatherthings){
            WeatherEntity weatherEntity = new WeatherEntity(weatherDTO.getLocation(),weatherDTO.getDate(),weatherDTO.getDescription(),weatherDTO.getTemp());
            try(EntityManager em = emf.createEntityManager()){
                em.getTransaction().begin();
                em.persist(weatherEntity);
                em.getTransaction().commit();
            }
        }



    }
}
