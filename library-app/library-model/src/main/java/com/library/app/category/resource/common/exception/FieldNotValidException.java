package com.library.app.category.resource.common.exception;

import javax.ejb.ApplicationException;

/**
 * @author fatu
 */
@ApplicationException
public class FieldNotValidException extends RuntimeException {

    private static final long serialVersionUID = 4525821332583716666L;

    private final String fieldName;

    public FieldNotValidException(String fieldName, String message) {
        super(message);
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }

    @Override
    public String toString() {
        return "FieldNotValidException{" +
            "fieldName='" + fieldName + '\'' +
            '}';
    }
}
