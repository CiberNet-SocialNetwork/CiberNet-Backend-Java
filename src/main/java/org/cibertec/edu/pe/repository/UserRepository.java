package org.cibertec.edu.pe.repository;

import org.cibertec.edu.pe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUsername(String username);
}
