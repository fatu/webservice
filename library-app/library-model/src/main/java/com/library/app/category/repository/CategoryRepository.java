package com.library.app.category.repository;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.library.app.category.model.Category;
import com.library.app.common.repository.GenericRepository;

@Stateless
public class CategoryRepository extends GenericRepository<Category> {

	@PersistenceContext
	EntityManager em;

	@Override
	protected Class<Category> getPersistentClass() {
		return Category.class;
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public boolean alreadyExists(final Category category) {
		return alreadyExists("name", category.getName(), category.getId());
	}

}