package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Post;
import org.cibertec.edu.pe.entity.User;
import org.cibertec.edu.pe.service.PostService;
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
@RequestMapping("/api/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@GetMapping("/findAll")
	public List<Post> findAll(){
		return postService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Post findById(@PathVariable Long id) {
		return postService.findById(id);
	}
	
	@GetMapping("/findPostsByUserId/{userId}")
	public List<Post> findPostsByUserId(@PathVariable Long userId) {
		return postService.findPostsByUserId(userId);
	}
	
	@PostMapping("/create")
	public ResponseDTO createPost(Post post) {
		return postService.createPost(post);
	}
	
	@PutMapping("/update/{id}")
	public ResponseDTO updatePost(@PathVariable Long id, @RequestBody Post post) {
		return postService.updatePost(id, post);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseDTO deletePost(@PathVariable Long id){
		postService.deletePost(id);
        return null;
    }
}
