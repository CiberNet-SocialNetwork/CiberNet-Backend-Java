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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseDTO deleteComment(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
