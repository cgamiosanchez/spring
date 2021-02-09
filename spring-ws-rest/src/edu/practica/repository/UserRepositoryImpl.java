package edu.practica.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import edu.practica.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User findByUsername(String username) {
		return em.find(User.class, username);
	}

}
