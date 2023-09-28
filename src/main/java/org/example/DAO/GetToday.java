package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetToday implements IWeather{
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    @Override
    public List<WeatherEntity> getAll() {
        return null;
    }

    @Override
    public WeatherEntity getTomorrow() {
        return null;
    }

    public WeatherEntity getToday() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d"); // Define the desired pattern

        try (EntityManager em = emf.createEntityManager()) {
            String formattedDate = today.format(formatter); // Format the LocalDate
            WeatherEntity weatherEntity = em.createQuery("SELECT w FROM WeatherEntity w WHERE date =:date", WeatherEntity.class)
                    .setParameter("date",formattedDate)
                    .getSingleResult();

            return weatherEntity;
        }
    }


}
