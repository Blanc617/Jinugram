package com.jinu.jinugram.like.service;

import org.springframework.stereotype.Service;

import com.jinu.jinugram.like.domain.Like;
import com.jinu.jinugram.like.repository.LikeRepository;

@Service
public class LikeService {
	
	private LikeRepository likeRepository;
	
	public LikeService(LikeRepository likeRepository) {
		this.likeRepository = likeRepository;
	}

	public Like addLike(int postId, int userId) {
	
		Like like = Like.builder()
					.postId(postId)
					.userId(userId)
					.build();
	
		return likeRepository.save(like);
	}
}
