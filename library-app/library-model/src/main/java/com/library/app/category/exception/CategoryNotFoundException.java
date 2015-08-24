package com.library.app.category.exception;

import javax.ejb.ApplicationException;

@ApplicationException
public class CategoryNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 6068378752576978396L;

}