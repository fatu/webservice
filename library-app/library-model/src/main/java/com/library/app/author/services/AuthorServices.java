package com.library.app.author.services;

import javax.ejb.Local;

import com.library.app.author.exception.AuthorNotFoundException;
import com.library.app.author.model.Author;
import com.library.app.author.model.filter.AuthorFilter;
import com.library.app.common.exception.FieldNotValidException;
import com.library.app.common.model.PaginatedData;

@Local
public interface AuthorServices {

	Author add(Author author) throws FieldNotValidException;

	void update(Author author) throws FieldNotValidException, AuthorNotFoundException;

	Author findById(Long id) throws AuthorNotFoundException;

	PaginatedData<Author> findByFilter(AuthorFilter authorFilter);

}
