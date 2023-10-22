package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Post;

public interface PostService {
	public List<Post> findAll();
	public Post findById(Long id);
	public List<Post> findPostsByUserId(Long userId);
	public ResponseDTO createPost(Post post);
	public ResponseDTO updatePost(Long id, Post post);
	public ResponseDTO deletePost(Long id);
}
