package com.jinu.jinugram.like.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jinu.jinugram.like.domain.Like;

public interface LikeRepository extends JpaRepository<Like, Integer>{

}
