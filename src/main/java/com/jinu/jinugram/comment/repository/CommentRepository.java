package com.jinu.jinugram.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jinu.jinugram.comment.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {

}