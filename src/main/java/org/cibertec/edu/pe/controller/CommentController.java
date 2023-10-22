package org.cibertec.edu.pe.controller;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Comment;
import org.cibertec.edu.pe.service.CommentService;
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
@RequestMapping("/api/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@GetMapping("/findAll")
	public List<Comment> findAll(){
		return commentService.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Comment findById(@PathVariable Long id) {
		return commentService.findById(id);
	}
	
	@GetMapping("/findCommentsByUserId/{userId}")
	public List<Comment> findCommentsByUserId(@PathVariable Long userId) {
		return commentService.findCommentsByUserId(userId);
	}
	
	@GetMapping("/findCommentsByPostId/{postId}")
	public List<Comment> findCommentsByPostId(@PathVariable Long postId) {
		return commentService.findCommentsByPostId(postId);
	}
	
	@PostMapping("/create")
	public ResponseDTO createComment(Comment comment) {
		return commentService.createComment(comment);
	}
	
	@PutMapping("/update/{id}")
	public ResponseDTO updateComment(@PathVariable Long id, @RequestBody Comment comment) {
		return commentService.updateComment(id, comment);
	}
	
	@DeleteMapping("/delete/{id}")
    public ResponseDTO deleteComment(@PathVariable Long id){
		commentService.deleteComment(id);
        return null;
    }
}
