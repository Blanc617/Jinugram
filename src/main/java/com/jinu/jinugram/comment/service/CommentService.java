package com.jinu.jinugram.comment.service;

import org.springframework.stereotype.Service;

import com.jinu.jinugram.comment.domain.Comment;
import com.jinu.jinugram.comment.repository.CommentRepository;

@Service
public class CommentService {
	
	private CommentRepository commentRepository;
	
	public CommentService(CommentRepository commentRepository) {
		this.commentRepository = commentRepository;
	}
	
	public Comment addComment(int postId, int userId, String contents) {
		
		Comment comment = Comment.builder()
			.postId(postId)
			.userId(userId)
			.contents(contents)
			.build();
		
		return commentRepository.save(comment);
		
	}

}