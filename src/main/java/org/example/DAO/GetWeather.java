package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.Entities.DailyWeatherEntity;
import org.example.Entities.WeatherEntity;
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

    /**
     * The getAll method seeks to get all DailyWeatherEntities from the database.
     * @return A list of DailyWeatherEntities
     */
    @Override
    public List<DailyWeatherEntity> getAll() {
        // Use of Java try-with-resources
        try (EntityManager em = emf.createEntityManager()) {
            TypedQuery<DailyWeatherEntity> query = em.createQuery("SELECT d FROM DailyWeatherEntity d", DailyWeatherEntity.class);
            List<DailyWeatherEntity> resultList = query.getResultList();
            return resultList;
        }
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
