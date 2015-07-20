package com.library.app.category.services.impl;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import com.library.app.category.model.Category;
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
    private Validator validator;

    @Before
    public void initTestCase() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        categoryServices = new CategoryServicesImpl();
        ((CategoryServicesImpl)categoryServices).validator = validator;
    }

    @Test
    public void addCategoryWithNullName() {
        try {
            categoryServices.add(new Category());
            fail("An error should have been thrown");
        } catch (FieldNotValidException e) {
            assertThat(e.getFieldName(), is(equalTo("name")));
        }

    }

}
