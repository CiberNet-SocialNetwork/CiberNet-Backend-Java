package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.dto.UserRequestDTO;
import org.cibertec.edu.pe.entity.User;
import org.cibertec.edu.pe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/findAll")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("/login")
	public ResponseDTO login(@RequestBody User user) {
		return userService.login(user.getUsername(), user.getPassword());
	}
	
	@PostMapping("/create")
	public ResponseDTO createUser(UserRequestDTO user) {
		return userService.createUser(user);
	}
	
	@PutMapping("/update/{id}")
	public ResponseDTO updateUser(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return null;
    }

}
