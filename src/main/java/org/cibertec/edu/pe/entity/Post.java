package org.cibertec.edu.pe.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	private String publicationDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private User user;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@JsonIgnore
	private Set<Comment> comments;
}
