package com.brian.socialmedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brian.socialmedia.model.Comment;


public interface CommentRepo extends JpaRepository<Comment, Long> {

}
