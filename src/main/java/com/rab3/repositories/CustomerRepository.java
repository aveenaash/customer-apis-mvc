package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rab3.entities.CustomerEntity;

@Repository

public class CustomerRepository {
	
	private EntityManager entityManager;
	
	
	@Transactional
	public void save(CustomerEntity customerEntity) {
		entityManager.persist(customerEntity);
		
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public CustomerEntity getByCustomerId(int id) {
		
		return entityManager.find(CustomerEntity.class,id);
	}
	
	

}
