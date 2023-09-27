package org.example;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.DAO.WeatherEntity;
import org.example.DTO.WeatherDTO;
import org.example.Scraping.*;
import org.example.api.WeatherAPIM;
import org.example.config.HibernateConfig;
import org.jsoup.select.Elements;

import java.util.List;


public class Main {
    private static EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();
    public static void main(String[] args) {
        List<WeatherDTO> weatherthings = ScrapingTools.DTOMaker();


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