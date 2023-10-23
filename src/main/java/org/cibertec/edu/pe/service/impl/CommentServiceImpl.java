package org.cibertec.edu.pe.service.impl;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Comment;
import org.cibertec.edu.pe.repository.CommentRepository;
import org.cibertec.edu.pe.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository commentRepository;

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
	public ResponseDTO createComment(Comment comment) {
		ResponseDTO response = new ResponseDTO();
		Comment dbComment = commentRepository.save(comment);
		response.setData(dbComment);
		response.setStatusCode(201);
		response.setError(false);
		response.setMessage("Comment created succesfully");
		return response;
	}

	@Override
	public ResponseDTO updateComment(Long id, Comment comment) {
		ResponseDTO response = new ResponseDTO();
		Comment dbComment = commentRepository.findById(id).get();
		dbComment.setContent(comment.getContent());
		dbComment.setPost(comment.getPost());
		dbComment.setPublicationDate(comment.getPublicationDate());
		dbComment.setUser(comment.getUser());
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
