package org.cibertec.edu.pe.service.impl;

import java.util.List;

import org.cibertec.edu.pe.dto.CommentRequestDTO;
import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Comment;
import org.cibertec.edu.pe.repository.CommentRepository;
import org.cibertec.edu.pe.repository.PostRepository;
import org.cibertec.edu.pe.repository.UserRepository;
import org.cibertec.edu.pe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Comment> findAll() {
		return (List<Comment>) commentRepository.findAll();
	}

	@Override
	public Comment findById(Long id) {
		return commentRepository.findById(id).orElseThrow(null);
	}

	@Override
	public List<Comment> findCommentsByUserId(Long userId) {
		return (List<Comment>) commentRepository.findByUserId(userId);
	}

	@Override
	public List<Comment> findCommentsByPostId(Long postId) {
		return (List<Comment>) commentRepository.findByPostId(postId);
	}

	@Override
	public ResponseDTO createComment(CommentRequestDTO comment) {
		ResponseDTO response = new ResponseDTO();
		try {
			Comment dbComment = commentRepository.save(new Comment());
			response.setData(dbComment);
			response.setStatusCode(201);
			response.setError(false);
			response.setMessage("Comment created succesfully");			
		}catch(Exception e) {
			response.setData(e.getMessage());
			response.setStatusCode(500);
			response.setError(false);
			response.setMessage("Error creating comment");	
		}
		return response;
	}

	@Override
	public ResponseDTO updateComment(Long id, CommentRequestDTO comment) {
		ResponseDTO response = new ResponseDTO();
		Comment dbComment = commentRepository.findById(id).get();
		dbComment.setContent(comment.getContent());
		dbComment.setPost(postRepository.findById(comment.getPostId()).orElseThrow(null));
		dbComment.setPublicationDate(comment.getPublicationDate());
		dbComment.setUser(userRepository.findById(comment.getUserId()).orElseThrow(null));
		Comment newComment = commentRepository.save(dbComment);
		response.setData(newComment);
		response.setStatusCode(201);
		response.setError(false);
		response.setMessage("Comment updated succesfully");
		return response;
	}

	@Override
	public ResponseDTO deleteComment(Long id) {
		ResponseDTO response = new ResponseDTO();
		Comment dbComment = commentRepository.findById(id).get();
		try {
			commentRepository.delete(dbComment);
			response.setData(dbComment);
			response.setStatusCode(200);
			response.setError(false);
			response.setMessage("Comment deleted succesfully");
		}catch (Exception e) {
			response.setData(e.getMessage());
			response.setStatusCode(500);
			response.setError(true);
			response.setMessage("Error while deleting comment");
		}
		return response;
	}

}
