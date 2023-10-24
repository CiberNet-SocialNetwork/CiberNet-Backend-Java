package org.cibertec.edu.pe.dto;

import lombok.Data;

@Data
public class PostRequestDTO {
	private String title;
	private String content;
	private String imageUrl;
	private String publicationDate;
	private Long userId;
}
