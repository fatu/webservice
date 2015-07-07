package com.library.app.category.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author fatu
 */
public class CategoryRepositoryUTest {

    private EntityManagerFactory emf;
    private EntityManager em;

    @Before
    public void initTestCase() throws Exception {
        emf = Persistence.createEntityManagerFactory("libraryPU");
        em = emf.createEntityManager();
    }

    @After
    public void closeEntityManager() throws Exception {
        em.close();
        emf.close();
    }

    @Test
    public void testAddCategoryAndFindIt() throws Exception {
        try {
            em.getTransaction().begin();

            em.getTransaction().commit();
            em.clear();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }
}
