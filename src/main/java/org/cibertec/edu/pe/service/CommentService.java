package org.cibertec.edu.pe.service;

import java.util.List;

import org.cibertec.edu.pe.dto.ResponseDTO;
import org.cibertec.edu.pe.entity.Comment;

public interface CommentService {
	public List<Comment> findAll();
	public Comment findById(Long id);
	public List<Comment> findCommentsByUserId(Long userId);
	public List<Comment> findCommentsByPostId(Long postId);
	public ResponseDTO createComment(Comment comment);
	public ResponseDTO updateComment(Long id, Comment comment);
	public ResponseDTO deleteComment(Long id);
}
