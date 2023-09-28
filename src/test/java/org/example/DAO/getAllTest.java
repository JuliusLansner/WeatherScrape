package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.config.HibernateConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class getAllTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private IWeather iWeather;

    @BeforeEach
    void setUp() {
        emf = HibernateConfig.getEntityManagerFactoryConfig();
        em = emf.createEntityManager();
        iWeather = new getAll();
        addTestData();
    }

    @AfterEach
    void tearDown() {
        removeTestData();
        em.close();
        emf.close();
    }

    /**
     * The getAll method finds all DailyWeatherEntities from the MAIN database
     */
    @Test
    void getAll() {
        List<DailyWeatherEntity> list = iWeather.getAll();
        assertNotNull(list);
        assertFalse(list.isEmpty());
    }

    /**
     * The addTestData method add two test entities to the MAIN database.
     */
    public void addTestData() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        DailyWeatherEntity testEntity1 = new DailyWeatherEntity("Berlin", "01/01", "TestData", "50", "30%", "50m/s");
        DailyWeatherEntity testEntity2 = new DailyWeatherEntity("London", "05/05", "TestData", "-10", "100%", "400m/s");

        em.persist(testEntity1);
        em.persist(testEntity2);

        transaction.commit();
    }

    /**
     * The removeTestData method removes the test data inserted into the MAIN database.
     */
    public void removeTestData() {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<DailyWeatherEntity> query = em.createQuery("select d from DailyWeatherEntity d where d.description = 'TestData'", DailyWeatherEntity.class);

        List<DailyWeatherEntity> resultList = query.getResultList();

        resultList.forEach(entity -> em.remove(entity));
        transaction.commit();
    }
}