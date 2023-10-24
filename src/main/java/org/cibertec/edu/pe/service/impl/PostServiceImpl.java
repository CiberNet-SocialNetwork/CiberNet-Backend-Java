package org.cibertec.edu.pe.service.impl;

import java.util.List;

import org.cibertec.edu.pe.dto.PostRequestDTO;
import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Post;
import org.cibertec.edu.pe.entity.User;
import org.cibertec.edu.pe.repository.PostRepository;
import org.cibertec.edu.pe.repository.UserRepository;
import org.cibertec.edu.pe.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

	@Autowired
	private PostRepository postRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).orElseThrow(null);
	}

	@Override
	public List<Post> findPostsByUserId(Long userId) {
		return (List<Post>) postRepository.findByUserId(userId);
	}

	@Override
	public ResponseDTO createPost(PostRequestDTO post) {
		ResponseDTO response = new ResponseDTO();
		Post newPost = new Post();
		newPost.setTitle(post.getTitle());
		newPost.setContent(post.getContent());
		newPost.setImageUrl(post.getImageUrl());
		newPost.setPublicationDate(post.getPublicationDate());
		newPost.setUser((User)userRepository.findById(post.getUserId()).orElseThrow(null));
		Post dbPost = postRepository.save(newPost);
		response.setData(dbPost);
		response.setStatusCode(201);
		response.setError(false);
		response.setMessage("Post created succesfully");
		return response;
	}

	@Override
	public ResponseDTO updatePost(Long id, PostRequestDTO post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO deletePost(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
