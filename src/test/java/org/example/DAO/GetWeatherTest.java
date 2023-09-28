package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.Entities.WeatherEntity;
import org.example.config.HibernateConfigTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class GetWeatherTest {
    private EntityManagerFactory emf;
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d");
    private static LocalDate today = LocalDate.now();
    private static GetWeather getWeather;

    @BeforeEach
    public void setup() {
        emf = HibernateConfigTest.getEntityManagerFactoryConfig();
        LocalDate tomorrow = today.plusDays(1);
        String tomorrowFormat = tomorrow.format(formatter);
        String todayFormat = today.format(formatter);

        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();


            em.createQuery("DELETE FROM WeatherEntity ").executeUpdate();


            em.createNativeQuery("INSERT INTO WeatherEntity(weather_id, date, description, location, temp) VALUES " +
                            "(1, ?, 'A nice warm day', 'Hillerød', '22')," +
                            "(2, ?, 'A nice warm day', 'Hillerød', '22')," +
                            "(3, '9/27', 'A nice warm day', 'Hillerød', '22')," +
                            "(4, '9/29', 'A nice warm day', 'Hillerød', '22')")
                    .setParameter(1, tomorrowFormat)
                    .setParameter(2, todayFormat)
                    .executeUpdate();

            em.getTransaction().commit();
        }
    }

    @Test
    void getTomorrow() {
        getWeather = new GetWeather();
        WeatherEntity weatherEntity = getWeather.getTomorrow();
        assertEquals(1, weatherEntity.getId());
    }

    @Test
    void getToday() {
        getWeather = new GetWeather();
        WeatherEntity weatherEntity = getWeather.getToday();
        assertEquals(2, weatherEntity.getId());
    }
}