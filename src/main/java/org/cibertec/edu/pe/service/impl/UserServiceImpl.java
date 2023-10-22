package org.cibertec.edu.pe.service.impl;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.User;
import org.cibertec.edu.pe.repository.UserRepository;
import org.cibertec.edu.pe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return (List<User>)userRepository.findAll();
	}

	@Override
	public User findById(Long id) {
		return userRepository.findById(id).orElseThrow(null);
	}

	@Override
	public ResponseDTO createUser(User user) {
		User dbUser = userRepository.findByUsername(user.getUsername());
		if(dbUser == null) dbUser = userRepository.save(user);
		ResponseDTO response = new ResponseDTO();
		response.setData(dbUser);
		return response;
	}

	@Override
	public ResponseDTO updateUser(Long id, User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO deleteUser(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
