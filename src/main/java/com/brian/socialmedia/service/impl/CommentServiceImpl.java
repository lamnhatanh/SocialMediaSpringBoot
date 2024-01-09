package com.brian.socialmedia.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.socialmedia.model.Comment;
import com.brian.socialmedia.model.Post;
import com.brian.socialmedia.repo.CommentRepo;
import com.brian.socialmedia.service.CommentService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepo commentRepo;

	@Override
	public void saveComment(Post post, String username, String content) {
		Comment comment = new Comment();
		comment.setContent(content);
		comment.setUsername(username);
		comment.setPostedDate(new Date());
		post.setComments(comment);
		commentRepo.save(comment);
	}

}
