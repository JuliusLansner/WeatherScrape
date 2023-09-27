package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;

import java.util.List;

public class getAll implements IWeather {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

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

    @Override
    public String getTomorrow() {
        return null;
    }

    @Override
    public WeatherEntity getToday() {
        return null;
    }
}