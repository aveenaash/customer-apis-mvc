package com.rab3.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rab3.entities.LoginEntity;

@Repository

public class LoginRepository {
	
	private EntityManager entityManager;
	
	@Transactional
	public void save(LoginEntity loginEntity) {
		entityManager.persist(loginEntity);
		
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
