package com.brian.socialmedia.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brian.socialmedia.model.Comment;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

}
