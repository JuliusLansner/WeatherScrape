package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GetTomorrow implements IWeather{
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    @Override
    public List<WeatherEntity> getAll() {
        return null;
    }

    @Override
    public WeatherEntity getTomorrow() {
        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plusDays(1);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d");
        String dateFormatted = tomorrow.format(format);

        try(EntityManager em = emf.createEntityManager()){
            WeatherEntity tm = em.createQuery("SELECT w FROM WeatherEntity w WHERE date =:date", WeatherEntity.class)
                    .setParameter("date",dateFormatted)
                    .getSingleResult();
            return tm;
        }

    }

    @Override
    public WeatherEntity getToday() {
        return null;
    }
}
