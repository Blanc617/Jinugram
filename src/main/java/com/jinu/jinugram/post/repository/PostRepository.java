package com.jinu.jinugram.post.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jinu.jinugram.post.domain.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

	// ORDER BY `id` DESC
	public List<Post> findAllByOrderByIdDesc();
	
}
