package com.library.app.category.services.impl;

import com.library.app.category.model.Category;
import com.library.app.category.services.CategoryServices;
import com.library.app.common.exception.FieldNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Iterator;
import java.util.Set;

/**
 * @author fatu
 */
public class CategoryServicesImpl implements CategoryServices{

    Validator validator;

    @Override
    public Category add(Category category) throws FieldNotValidException {
        Set<ConstraintViolation<Category>> errors = validator.validate(category);
        Iterator<ConstraintViolation<Category>> itErrors = errors.iterator();
        if (itErrors.hasNext()) {
            ConstraintViolation<Category> violation = itErrors.next();
            throw new FieldNotValidException(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return null;
    }
}
