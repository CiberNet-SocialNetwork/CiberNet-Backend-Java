package org.cibertec.edu.pe.dto;

import lombok.Data;

@Data
public class CommentRequestDTO {
	private String content;
	private String publicationDate;
	private Long postId;
	private Long userId;
}
