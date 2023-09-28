package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetWeather implements IWeather {
    /**
     * GetWeather class has several methods with their own responsibilities.
     */
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d");
    LocalDate today = LocalDate.now();


    @Override
    public List<WeatherEntity> getAll() {
        return null;
    }


    /**
     *
     * @return returns a WeatherEntity object with the weather data of tomorrow, which is made of data selected from our database.
     */
    @Override
    public WeatherEntity getTomorrow() {
        LocalDate tomorrow = today.plusDays(1);
        String dateFormatted = tomorrow.format(formatter);
        try(EntityManager em = emf.createEntityManager()){
            WeatherEntity tm = em.createQuery("SELECT w FROM WeatherEntity w WHERE date =:date", WeatherEntity.class)
                    .setParameter("date",dateFormatted)
                    .getSingleResult();
            return tm;
        }

    }

    @Override
    public WeatherEntity getToday() {
        try (EntityManager em = emf.createEntityManager()) {
            String formattedDate = today.format(formatter); // Format the LocalDate
            WeatherEntity weatherEntity = em.createQuery("SELECT w FROM WeatherEntity w WHERE date =:date", WeatherEntity.class)
                    .setParameter("date",formattedDate)
                    .getSingleResult();

            return weatherEntity;
        }
    }
}
