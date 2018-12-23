package com.boot.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.boot.model.ModelType;
import org.springframework.stereotype.Repository;

@Repository
public class ModelTypeRepository {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Create
	 */
	public ModelType create(ModelType mt) {
		entityManager.persist(mt);
		entityManager.flush();
		return mt;
	}

	/**
	 * Update
	 */
	public ModelType update(ModelType mt) {
		mt = entityManager.merge(mt);
		entityManager.flush();
		return mt;
	}

	/**
	 * Delete
	 */
	public void delete(ModelType mt) {
		entityManager.remove(mt);
		entityManager.flush();
	}

	/**
	 * Find
	 */
	public ModelType find(Long id) {
		return entityManager.find(ModelType.class, id);
	}
}
