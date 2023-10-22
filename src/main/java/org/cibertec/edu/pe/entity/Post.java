package org.cibertec.edu.pe.entity;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String content;
	private String imageUrl;
	public Date publicationDate;
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	@OneToMany(mappedBy = "post")
	private Set<Comment> comments;
}
