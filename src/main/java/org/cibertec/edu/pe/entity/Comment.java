package org.cibertec.edu.pe.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	private Date publicationDate;
	@ManyToOne
	@JoinColumn(name="postId")
	private Post post;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
}
