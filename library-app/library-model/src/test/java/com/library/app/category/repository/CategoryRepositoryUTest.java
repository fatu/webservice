package com.library.app.category.repository;

import com.library.app.category.model.Category;
import com.library.app.commontests.utils.DBCommandTransactionalExecutor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static com.library.app.commontests.category.CategoryForTestsRepository.java;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * @author fatu
 */
public class CategoryRepositoryUTest {

    private EntityManagerFactory emf;
    private EntityManager em;
    private CategoryRepository categoryRepository;
    private DBCommandTransactionalExecutor dBCommandTransactionalExecutor;

    @Before
    public void initTestCase() throws Exception {
        emf = Persistence.createEntityManagerFactory("libraryPU");
        em = emf.createEntityManager();

        categoryRepository = new CategoryRepository();
        categoryRepository.em = em;

        dBCommandTransactionalExecutor = new DBCommandTransactionalExecutor(em);
    }

    @After
    public void closeEntityManager() throws Exception {
        em.close();
        emf.close();
    }

    @Test
    public void testAddCategoryAndFindIt() throws Exception {
        Long categoryAddedId = dBCommandTransactionalExecutor.executeCommand(() -> categoryRepository.add(java()).getId());

        assertThat(categoryAddedId, is(notNullValue()));

        final Category category = categoryRepository.findById(categoryAddedId);
        assertThat(category, is(notNullValue()));
        assertThat(category.getName(), is(equalTo(java().getName())));
    }
}
