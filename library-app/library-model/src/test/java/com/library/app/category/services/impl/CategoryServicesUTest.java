package com.library.app.category.services.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.mockito.Mockito.*;
import static com.library.app.commontests.category.CategoryForTestsRepository.*;

import com.library.app.category.exception.CategoryExistentException;
import com.library.app.category.model.Category;
import com.library.app.category.repository.CategoryRepository;
import com.library.app.category.services.CategoryServices;
import com.library.app.common.exception.FieldNotValidException;
import com.sun.xml.internal.ws.developer.MemberSubmissionAddressing;
import org.junit.Before;
import org.junit.Test;

import javax.validation.Validation;
import javax.validation.Validator;

/**
 * @author fatu
 */
public class CategoryServicesUTest {
    private CategoryServices categoryServices;
    private CategoryRepository categoryRepository;
    private Validator validator;

    @Before
    public void initTestCase() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        categoryRepository = mock(CategoryRepository.class);

        categoryServices = new CategoryServicesImpl();
        ((CategoryServicesImpl)categoryServices).validator = validator;
        ((CategoryServicesImpl)categoryServices).categoryRepository = categoryRepository;
    }

    @Test
    public void addCategoryWithNullName() {
        addCategoryWithInvalidName(null);
    }

    @Test
    public void addCategoryWithShortName() {
        addCategoryWithInvalidName("A");
    }

    @Test
    public void addCategoryWithLongName() {
        addCategoryWithInvalidName("This is a long name that will cause an exception to be thrown");
    }

    @Test(expected = CategoryExistentException.class)
    public void addCategoryWithExistentName() throws Exception {
        when(categoryRepository.alreadyExists(java())).thenReturn(true);

        categoryServices.add(java());
    }

    @Test
    public void addValidCategory() throws Exception {
        when(categoryRepository.alreadyExists(java())).thenReturn(false);
        when(categoryRepository.add(java())).thenReturn(categoryWithId(java(), 1L));

        Category categoryAdded = categoryServices.add(java());
        assertThat(categoryAdded.getId(), is(equalTo(1L)));

    }

    private void addCategoryWithInvalidName(String name) {
        try {
            categoryServices.add(new Category(name));
            fail("An error should have been thrown");
        } catch (FieldNotValidException e) {
            assertThat(e.getFieldName(), is(equalTo("name")));
        }
    }

}
