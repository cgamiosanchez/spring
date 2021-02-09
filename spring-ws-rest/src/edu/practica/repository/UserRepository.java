package edu.practica.repository;

import edu.practica.entity.User;

public interface UserRepository {

	User findByUsername(String username);
}
