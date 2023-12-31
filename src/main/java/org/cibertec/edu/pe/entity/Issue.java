package org.cibertec.edu.pe.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Issue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private User user;
}
