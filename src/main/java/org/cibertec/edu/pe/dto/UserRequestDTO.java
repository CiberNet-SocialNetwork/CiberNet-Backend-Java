package org.cibertec.edu.pe.dto;

import lombok.Data;

@Data
public class UserRequestDTO {
	private String username;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	private String imageUrl;
}
