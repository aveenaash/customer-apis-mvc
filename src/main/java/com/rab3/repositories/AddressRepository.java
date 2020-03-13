package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rab3.entities.AddressEntity;

@Repository

public class AddressRepository {
	
	private EntityManager entityManager;
	
	@Transactional
	public void save(AddressEntity addressEntity) {
		entityManager.persist(addressEntity);
	}


	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	
}
