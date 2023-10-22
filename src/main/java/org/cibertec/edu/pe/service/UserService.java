package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.User;

public interface UserService {
	public List<User> findAll();
	public User findById(Long id);
	public ResponseDTO createUser(User user);
	public ResponseDTO updateUser(Long id, User user);
	public ResponseDTO deleteUser(Long id);
	public ResponseDTO login(String username, String password);
}
